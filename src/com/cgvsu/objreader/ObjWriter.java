package com.cgvsu.objreader;

import com.cgvsu.math.Vector3f;
import com.cgvsu.model.Model;
import com.cgvsu.model.Polygon;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Vector;

public class ObjWriter {
    public static void writeObj(String filePath, Model obj) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            List<Vector3f> vertices = obj.vertices;
            List<Polygon> faces = obj.polygons;

            for (Vector3f vertex : vertices) {
                writer.write(vertex.toString() + "\n");
            }

            for (Polygon face : faces) {
                writer.write("f");
                for (int vertexIndex : face.getVertexIndices()) {
                    int increment = vertexIndex + 1;
                    writer.write(" " + increment);
                }
                writer.write(System.lineSeparator());
            }

            System.out.println("Модель успешно сохранена в " + filePath);
        } catch (IOException e) {
            System.err.println("Ошибка при сохранении модели: " + e.getMessage());
        }
    }
}