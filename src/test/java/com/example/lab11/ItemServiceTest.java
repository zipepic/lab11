package com.example.lab11;
import com.example.lab11.model.Item;
import com.example.lab11.repo.ItemRepository;
import com.example.lab11.service.ItemService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

//@ExtendWith(MockitoExtension.class)
class ItemServiceTest {

//    @Mock
//    private ItemRepository itemRepository;
    private ItemService itemService;

    private List<Item> items;

    @BeforeEach
    void setUp() {
        items = Arrays.asList(
                new Item(1, "Watch", "Luxury watch", "none.png", new BigDecimal(500)),
                new Item(2, "Laptop", "Gaming laptop", "none.png", new BigDecimal(1200)),
                new Item(3, "Ring", "Gold ring", "ring.png", new BigDecimal(300)),
                new Item(4, "Smartphone", "Latest smartphone model", "phone.png", new BigDecimal(800)),
                new Item(5, "Camera", "Professional camera", "camera.png", new BigDecimal(1500))
        );
    }
    @Test
    void testGetAllItems() {
        assertEquals(items.size(), 5);
    }

    @Test
    void testGetItemById() {

        assertEquals("Watch", items.get(0).getItemName());
    }
}
