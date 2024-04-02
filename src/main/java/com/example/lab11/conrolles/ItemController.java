package com.example.lab11.conrolles;

import com.example.lab11.model.Item;
import com.example.lab11.service.ItemService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.util.List;

@Controller
@RequestMapping("/items")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping
    public String getAllItems(Model model) {
        List<Item> items = itemService.getAllItems();
        model.addAttribute("items", items);
        return "item/list";
    }

    @GetMapping("/{id}")
    public String getItemById(@PathVariable int id, Model model) {
        Item item = itemService.getItemById(id);
        model.addAttribute("item", item);
        return "item/view";
    }

    @GetMapping("/add")
    public String showAddItemForm(Model model) {
        model.addAttribute("item", new Item());
        return "item/add";
    }

    @PostMapping("/add")
    public String addItem(@ModelAttribute Item item) {
        itemService.addItem(item);
        return "redirect:/items";
    }

    @GetMapping("/edit/{id}")
    public String showEditItemForm(@PathVariable int id, Model model) {
        Item item = itemService.getItemById(id);
        model.addAttribute("item", item);
        return "item/edit";
    }

    @PostMapping("/edit/{id}")
    public String updateItem(@PathVariable int id, @ModelAttribute Item item) {
        itemService.updateItem(id, item);
        return "redirect:/items";
    }

    @GetMapping("/delete/{id}")
    public String deleteItem(@PathVariable int id) {
        itemService.deleteItem(id);
        return "redirect:/items";
    }
    @PostMapping("/download")
    public void downloadItems(HttpServletResponse response) {
        List<Item> items = itemService.getAllItems();
        try {
            File file = new File("items.txt");
            FileWriter writer = new FileWriter(file);
            for (Item item : items) {
                writer.write("ID: " + item.getID() + ", Item Name: " + item.getItemName() + ", Description: " + item.getDescription() + ", Photos: " + item.getPhotos() + ", Price: " + item.getPrice() + "\n");
            }
            writer.close();

            // Установка заголовков HTTP для скачивания файла
            response.setContentType("text/plain");
            response.setHeader("Content-Disposition", "attachment; filename=items.txt");
            response.setContentLength((int) file.length());

            // Чтение файла и запись его в выходной поток
            FileInputStream fileInputStream = new FileInputStream(file);
            OutputStream outputStream = response.getOutputStream();
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = fileInputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
            outputStream.flush();
            fileInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
            // Обработка ошибки, если не удалось создать или записать файл
        }
    }
}
