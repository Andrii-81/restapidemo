package com.example.restapidemo.service.impl;

import com.example.restapidemo.model.Customer;
import com.example.restapidemo.model.CustomerFileName;
import com.example.restapidemo.service.FileService;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

@Service
public class FileServiceImpl implements FileService {

    @Override
    public String createCSV (Customer customer) {
        String uniqueFileName = null;
        try {
            uniqueFileName = createUniqueFileName();
            String pathOfFile = "C:\\My_Java_projects_itvdn\\___Spring_with_Victor___\\RestApiClientJson_2024_02_24\\restapidemo\\src\\main\\java\\csvFiles\\"
                    + uniqueFileName;

            PrintWriter pw = new PrintWriter(new File(pathOfFile));
            StringBuilder sb = new StringBuilder();

            sb.append(customer.getId());
            sb.append(",");
            sb.append(customer.getName());
            sb.append(",");
            sb.append(customer.getAge());
            sb.append(",");
            sb.append(customer.getMobile_no());

            pw.write(sb.toString());
            pw.close();

        } catch (Exception e) {

        }
        return uniqueFileName;
    }
    @Override
    public String createUniqueFileName() {
        String uniqueFileName = null;
        Set<String> setOfNames = getAllFileNames();
        // КОД ПО ПОЛУЧЕНИЮ УНИКАЛЬНОСТИ ИМЕНИ   =========== ЧЕРЕЗ РЕКУРСИЮ

        uniqueFileName = Integer.toString((int) (Math.random() * 1000));

        for (String name : setOfNames) {
            if (uniqueFileName != name) {
                return uniqueFileName;
            }
            else {
                createUniqueFileName();
            }
        }

        return uniqueFileName;
    }
    @Override
    public Customer readFile(String fileName) {
        Customer customer = null;
        ArrayList<Object> tmp_list = new ArrayList<>();

        try (BufferedReader br = Files.newBufferedReader(Paths.get("C:\\My_Java_projects_itvdn\\___Spring_with_Victor___\\RestApiClientJson_2024_02_24\\restapidemo\\src\\main\\java\\csvFiles\\"
        + fileName))) {
            String str = "";
            while((str = br.readLine()) != null) {
                StringTokenizer tokenizer = new StringTokenizer(str, ",");

                while (tokenizer.hasMoreElements()) {
                    tmp_list.add(tokenizer.nextElement());
                }
            }
            String id = tmp_list.get(1).toString();
            String name = tmp_list.get(2).toString();
            String age = tmp_list.get(3).toString();
            String mobile_no = tmp_list.get(4).toString();

            customer.setId(Integer.parseInt(id));
            customer.setName(name);
            customer.setAge(Integer.parseInt(age));
            customer.setMobile_no(mobile_no);

        } catch (Exception e) {

        }
        //
        return customer;
    }

    @Override
    public Set<String> getAllFileNames() {
        String[] stringOfNames = null;
        Set<String> setOfNames = null;
        // System.out -указываем что будем-поток вывода(а не поток ввода)  // кодировка    // флажок автоочистки будера=ТРУ
        try (PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out, "UTF-8"), true)){

            // В dir присваиваем путь директории
            File dir = new File("C:\\My_Java_projects_itvdn\\___Spring_with_Victor___\\RestApiClientJson_2024_02_24\\restapidemo\\src\\main\\java\\csvFiles\\");

            // Существует ли директория И является ли этот путь директорией
            if (dir.exists() && dir.isDirectory()) {
                stringOfNames = dir.list(); // считать все содержимое директории и записать в строковый массив
                for (int i = 0; i < stringOfNames.length; i++) {
                    //pw.println(stringOfNames[i]);
                    setOfNames.add(stringOfNames[i]);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return setOfNames;
    }


}
