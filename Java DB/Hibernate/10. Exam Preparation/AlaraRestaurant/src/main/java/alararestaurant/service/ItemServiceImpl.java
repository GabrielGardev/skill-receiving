package alararestaurant.service;

import alararestaurant.domain.dtos.json.ItemDto;
import alararestaurant.domain.entities.Category;
import alararestaurant.domain.entities.Item;
import alararestaurant.repository.CategoryRepository;
import alararestaurant.repository.ItemRepository;
import alararestaurant.util.FileUtil;
import alararestaurant.util.ValidationUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class ItemServiceImpl implements ItemService {

    private final static String ITEMS_JSON_FILE = System.getProperty("user.dir") + "\\src\\main\\resources\\files\\items.json";

    private final ItemRepository itemRepository;
    private final CategoryRepository categoryRepository;
    private final FileUtil fileUtil;
    private final ModelMapper mapper;
    private final Gson gson;
    private final ValidationUtil validationUtil;

    public ItemServiceImpl(ItemRepository itemRepository, CategoryRepository categoryRepository, FileUtil fileUtil, ModelMapper mapper, Gson gson, ValidationUtil validationUtil) {
        this.itemRepository = itemRepository;
        this.categoryRepository = categoryRepository;
        this.fileUtil = fileUtil;
        this.mapper = mapper;
        this.gson = gson;
        this.validationUtil = validationUtil;
    }

    @Override
    public Boolean itemsAreImported() {
        return this.itemRepository.count() > 0;
    }

    @Override
    public String readItemsJsonFile() throws IOException {
        return fileUtil.readFile(ITEMS_JSON_FILE);
    }

    @Override
    public String importItems(String items) {
        StringBuilder sb = new StringBuilder();

        ItemDto[] dtos = gson.fromJson(items, ItemDto[].class);
        for (ItemDto dto : dtos) {
            Item item = mapper.map(dto, Item.class);
            if (!validationUtil.isValid(item) || itemRepository.findByName(dto.getName()) != null){
                sb.append("Invalid data format.").append(System.lineSeparator());
                continue;
            }

            Category category = categoryRepository.findByName(dto.getCategory());

            if (category == null){
                category = new Category();
                category.setName(dto.getCategory());

                if (!validationUtil.isValid(category)){
                    sb.append("Invalid data format.").append(System.lineSeparator());
                    continue;
                }
                categoryRepository.saveAndFlush(category);
            }
            item.setCategory(category);

            itemRepository.saveAndFlush(item);
            sb.append(String.format("Record %s successfully imported.", item.getName()))
                    .append(System.lineSeparator());
        }


        return sb.toString().trim();
    }
}
