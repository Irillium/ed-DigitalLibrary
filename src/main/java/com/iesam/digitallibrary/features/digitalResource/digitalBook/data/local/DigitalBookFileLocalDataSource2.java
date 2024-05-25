package com.iesam.digitallibrary.features.digitalResource.digitalBook.data.local;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;
import com.google.gson.reflect.TypeToken;
import com.iesam.digitallibrary.features.digitalResource.digitalBook.domain.DigitalBook;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class DigitalBookFileLocalDataSource2 implements DigitalBookData{
    private String nameFile = "book.txt";

    private final Gson gson;

    private final Type typeList = new TypeToken<ArrayList<DigitalBook>>() {}.getType();

    public DigitalBookFileLocalDataSource2() {
        gson = new GsonBuilder()
                .registerTypeAdapter(LocalDate.class, (JsonDeserializer<LocalDate>) (json, typeOfT, context) ->
                        LocalDate.parse(json.getAsJsonPrimitive().getAsString()))
                .create();
    }

    public void save(DigitalBook model) {
        List<DigitalBook> models = findAll();
        models.add(model);
        saveToFile(models);
    }

    public void saveList(List<DigitalBook> models) {
        saveToFile(models);
    }

    private void saveToFile(List<DigitalBook> models) {
        try (FileWriter myWriter = new FileWriter(nameFile)) {
            gson.toJson(models, myWriter);
            System.out.println("Datos guardados correctamente");
        } catch (IOException e) {
            System.out.println("Ha ocurrido un error al guardar la información.");
            e.printStackTrace();
        }
    }

    public DigitalBook findById(String id) {
        List<DigitalBook> models = findAll();
        for (DigitalBook model : models) {
            if (Objects.equals(model.getIsbn(), id)) {
                return model;
            }
        }
        return null;
    }

    public List<DigitalBook> findAll() {
        List<DigitalBook> models = new ArrayList<>();
        try (Scanner myReader = new Scanner(new File(nameFile))) {
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                models = gson.fromJson(data, typeList);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Ha ocurrido un error al obtener el listado.");
            e.printStackTrace();
        }
        return models;
    }

    public void delete(String modelId) {
        List<DigitalBook> newList = new ArrayList<>();
        List<DigitalBook> models = findAll();
        for (DigitalBook model : models) {
            if (!model.getIsbn().equals(modelId)) {
                newList.add(model);
            }
        }
        saveList(newList);
    }
}
