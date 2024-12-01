package com.cgvsu.model;

import com.cgvsu.objreader.ObjReader;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ModelTest {
    @Test
    void deleteVertice() throws IOException {
//Polygons в obj
//f 1 2 4 3
//f 3 4 8 7
//f 7 8 6 5
//f 5 6 2 1
//f 3 7 5 1
//f 8 4 2 6
//Polygons в модели
//[0, 1, 3, 2]
//[2, 3, 7, 6]
//[6, 7, 5, 4]
//[4, 5, 1, 0]
//[2, 6, 4, 0]
//[7, 3, 1, 5]

        Model model = initModel();
        //Т.к в obj формате отсчет начинается с 1, а модели хранятся в классах начиная с нуля,
        //Чтобы удалить вершину под номером 2 в obj формате, необходимо задать значение 1
        model.deleteVertice(1);

        //В Итоге полигоны в ответе должны быть такими
        //Они на 1 меньше чем в obj формате
        //И элементы большие чем значение удаленной вершины уменьшены на 1
        // (например были вершины 1,3,4) мы удаляем вершину 2
        // в итоге получаем такой набор вершин (1,2,3)
        List<List<Integer>> faces = Arrays.asList(
                Arrays.asList(1, 2, 6, 5),
                Arrays.asList(5, 6, 4, 3),
                Arrays.asList(1, 5, 3, 0)
        );


        assertEquals(faces.size(), model.polygons.size());
        for (int i = 0; i < model.polygons.size(); i++) {
            assertEquals(faces.get(i), model.polygons.get(i).getVertexIndices());
        }
    }

    public static Model initModel() throws IOException {
        Path fileName = Path.of("src/com/cgvsu/3DModels/CaracalCube/caracal_cube.obj");
        String fileContent = Files.readString(fileName);
        return ObjReader.read(fileContent);
    }

}