package Ankara.kara.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import Ankara.kara.business.abstracts.ProductService;
import Ankara.kara.core.utilities.results.DataResult;
import Ankara.kara.core.utilities.results.Result;
import Ankara.kara.core.utilities.results.SuccessDataResult;
import Ankara.kara.core.utilities.results.SuccessResult;
import Ankara.kara.dataAccess.abstracts.ProductDao;
import Ankara.kara.entities.concretes.Product;
import Ankara.kara.entities.dtos.ProductWithCategoryDto;

@Service
public class ProductManager implements ProductService {

	private ProductDao productDao;
	
	@Autowired
	public ProductManager(ProductDao productDao) {
		super();
		this.productDao = productDao;
	}

	@Override
	public DataResult<List<Product>> getAll() {
		    
			return new SuccessDataResult<List<Product>>
			(this.productDao.findAll(),"Data is listed.");			
				
	}

	@Override
	public Result add(Product product) {
		this.productDao.save(product);
		return new SuccessResult("Product Added");
	}

	@Override
	public DataResult<Product> getByProductName(String productName) {
		return new SuccessDataResult<Product>
		(this.productDao.getByProductName(productName),"Data is listed.");	
	}

	@Override
	public DataResult<Product> getByProductNameAndCategory_CategoryId(String productName, int categoryId) {
		//business codes
		
		return new SuccessDataResult<Product>
		(this.productDao.getByProductNameAndCategory_CategoryId(productName,categoryId),"Data is listed.");
	}

	@Override
	public DataResult<List<Product>> getByProductNameOrCategory_CategoryId(String productName, int categoryId) {
		return new SuccessDataResult<List<Product>>
		(this.productDao.getByProductNameOrCategory_CategoryId(productName, categoryId),"Data is listed.");
	}

	@Override
	public DataResult<List<Product>> getByCategoryIdIn(List<Integer> categories) {
		return new SuccessDataResult<List<Product>>
		(this.productDao.getByCategoryIn(categories),"Data is listed.");
	}

	@Override
	public DataResult<List<Product>> getByProductNameContains(String productName) {
		return new SuccessDataResult<List<Product>>
		(this.productDao.getByProductNameContains(productName),"Data is listed.");
	}

	@Override
	public DataResult<List<Product>> getByProductNameStartsWith(String productName) {
		return new SuccessDataResult<List<Product>>
		(this.productDao.getByProductNameStartsWith(productName),"Data is listed.");
	}

	@Override
	public DataResult<List<Product>> getByNameAndCategory(String productName, int categoryId) {
		return new SuccessDataResult<List<Product>>
		(this.productDao.getByNameAndCategory(productName,categoryId),"Data is listed.");
	}

	@Override
	public  DataResult<List<Product>> getAll(int pageNo, int pageSize) {
		
		Pageable pageable=PageRequest.of(pageNo-1, pageSize);
		
		return new SuccessDataResult <List<Product>>
		(this.productDao.findAll(pageable).getContent()) ;
	}

	@Override
	public DataResult<List<Product>> getAllSortedByAscendingName() {
		Sort sort= Sort.by(Sort.Direction.ASC,"productName");
		return new SuccessDataResult<List<Product>>
		(this.productDao.findAll(sort),"Success");		
	}

	@Override
	public DataResult<List<Product>> getAllSortedByDescendingName() {
		Sort sort= Sort.by(Sort.Direction.DESC,"productName");
		return new SuccessDataResult<List<Product>>
		(this.productDao.findAll(sort),"Success");
	}

	@Override
	public DataResult<List<Product>> getAllSortedByAscendingPrice() {
		Sort sort= Sort.by(Sort.Direction.ASC,"unitPrice");
		return new SuccessDataResult<List<Product>>
		(this.productDao.findAll(sort),"Success");
	}

	@Override
	public DataResult<List<Product>> getAllSortedByDescendingPrice() {
		Sort sort= Sort.by(Sort.Direction.DESC,"unitPrice");
		return new SuccessDataResult<List<Product>>
		(this.productDao.findAll(sort),"Success");
	}

	@Override
	public DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails() {
		return new SuccessDataResult<List<ProductWithCategoryDto>>
		(this.productDao.getProductWithCategoryDetails(),"Success");
	}
	
	
	
}
