package ie.atu.week6;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
@@ -18,19 +19,20 @@ public ProductController(ProductService myService) {
    private List<Product> list = new ArrayList<>();
    //Creating a class which is interested in requests and responses. Separation of Concern
    @PostMapping("/create")
    public List<Product> newProduct (@RequestBody Product product){
        public List<Product> newProduct (@Valid @RequestBody Product product){
            list = myService.addProduct(product);
            return list;
        }
        @PutMapping("/update/{id}")
        public List<Product> updateProduct ( @PathVariable int id, @RequestBody Product product){
            public List<Product> updateProduct ( @Valid @PathVariable int id, @RequestBody Product product){
                list = myService.updateProduct(id, product);
                return list;
            }

            @DeleteMapping("/update/{id}")
            public List<Product> deleteProduct ( @PathVariable int id, @RequestBody Product product){
                list = myService.deleteProduct(id, product);
                @DeleteMapping("/delete/{id}")
                public List<Product> deleteProduct ( @Valid @PathVariable int id){

                    list = myService.deleteProduct(id);
                    return list;
                }
            }
        }
    }
}