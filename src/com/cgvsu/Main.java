package com.cgvsu;

import com.cgvsu.model.Model;
import com.cgvsu.objreader.ObjReader;
import com.cgvsu.objreader.ObjWriter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) throws IOException {

        Path fileName = Path.of("src/com/cgvsu/3DModels/CaracalCube/caracal_cube.obj");
        String fileContent = Files.readString(fileName);

//        System.out.println("Loading model ...");
        Model model = ObjReader.read(fileContent);
        //отсчет идет относительно нуля, поэтому в итогов obj файле удалятся индексы
        //содержающие номера i + 1
        model.deleteVertice(1);
        //ObjWriter не полноценный, но для демонстарции результата работы программы его достаточно
        ObjWriter.writeObj("a.obj", model);
//        System.out.println("Vertices: " + model.vertices.size());
//        System.out.println("Texture vertices: " + model.textureVertices.size());
//        System.out.println("Normals: " + model.normals.size());
//        System.out.println("Polygons: " + model.polygons.size());
    }
}
