package Ankara.kara.business.abstracts;
import java.util.List;

import Ankara.kara.core.utilities.results.DataResult;
import Ankara.kara.core.utilities.results.Result;
import Ankara.kara.entities.concretes.Product;
import Ankara.kara.entities.dtos.ProductWithCategoryDto;

public interface ProductService {
	 DataResult<List<Product>> getAll();
	 DataResult<List<Product>> getAll(int pageNo, int pageSize);
	 DataResult<List<Product>> getAllSortedByAscendingName();
	 DataResult<List<Product>> getAllSortedByDescendingName();
	 DataResult<List<Product>> getAllSortedByAscendingPrice();
	 DataResult<List<Product>> getAllSortedByDescendingPrice();
     Result add(Product product);
    
     DataResult<Product> getByProductName(String productName);
	  
     DataResult<Product> getByProductNameAndCategory_CategoryId(String productName, int categoryId);
	  
     DataResult<List<Product>> getByProductNameOrCategory_CategoryId(String productName, int categoryId);
	  
     DataResult<List<Product>> getByCategoryIdIn(List<Integer> categories);
	  
     DataResult<List<Product>> getByProductNameContains(String productName);
	  
     DataResult<List<Product>> getByProductNameStartsWith(String productName);

     DataResult<List<Product>> getByNameAndCategory(String productName, int categoryId);
     
	 DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails();

}
