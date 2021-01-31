package com.company;

import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class ReadCSV {

    String csv = "https://opendata-ajuntament.barcelona.cat/data/dataset/cb293930-f483-4457-bf57-50a68e9b01b3/resource/8188d1b7-9dd8-4cc0-85b8-13c4b0b551e2/download/2008_naixements_lloc-de-naixement.csv";

    CsvToBean<Nacimiento> parse(){
        URL url = null;
        BufferedReader bf = null;
        CSVReader reader = null;

        try {
            url = new URL(csv);
            bf = new BufferedReader(new InputStreamReader(url.openStream()));
            reader = new CSVReader(bf);
        } catch (IOException e) {
            e.printStackTrace();
        }

        CsvToBean<Nacimiento> nacimientoCsvToBean = new CsvToBeanBuilder(reader).withType(Nacimiento.class).withIgnoreLeadingWhiteSpace(true).build();

        return nacimientoCsvToBean;
    }
}
