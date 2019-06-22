package com.example.cosmicapp.commons.extras;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class CreatorXLS<T> {

    private Class clazz;

    public CreatorXLS(Class clazz) {
        this.clazz = clazz;
    }

    public void createFile(List<T> series, String path, String fileName) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, IOException {
        //obiekt reprezentujący cały plik excel
        HSSFWorkbook workbook =  new HSSFWorkbook();
        HSSFSheet hssfSheet = workbook.createSheet(fileName);

        //todo - dodać style arkusza

        List<String> columns = new ArrayList<>();

        //refleksja
         for(Field f: clazz.getDeclaredFields()){
             columns.add(f.getName());
         }

         //Headers
        Row  header = hssfSheet.createRow(0);
        for (int i = 0; i < columns.size(); i++) {
            Cell cell = header.createCell(i);
            cell.setCellValue(columns.get(i));
            // todo - usupełni style cell
        }

        //Cells
        for (int i = 0; i < series.size(); i++) {
            HSSFRow row = hssfSheet.createRow(i + 1);

            for (int j = 0; j < columns.size(); j++) {
                HSSFCell cell = row.createCell(j);
                Method method = series.get(i)
                        .getClass()
                        .getMethod("get" + columns.get(j).substring(0,1).toUpperCase() + columns.get(j).substring(1));

                Object result  = method.invoke(series.get(i));
                cell.setCellValue(String.valueOf(result));

            }
        }

        String file = path + fileName + "_" + System.currentTimeMillis() + ".xls";
        workbook.write(new File(file));
        workbook.close();

    }
}
