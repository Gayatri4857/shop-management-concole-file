package product_management;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Iterator;


public class ProductManagement {
	static ArrayList<Product> al = new ArrayList<> ();
	public static void productManagement() throws IOException{
		Scanner scanner = new Scanner(System.in);
		boolean canikeeprunningprogram = true;
		while(canikeeprunningprogram == true) {
			System.out.println("##WELLCOME TO PRODUCT MANAGEMENT##");
			System.out.println("1. Add Product:");
			System.out.println("2. Edit Product:");
			System.out.println("3. Delete Product:");
			System.out.println("4. Search Product:");
			System.out.println("5. Quit Product:");
			System.out.println("\n");
			
			int optionselectedbyproduct = scanner.nextInt();
			if(optionselectedbyproduct == ProductOptions.Quit_Product) {
				File file = new File("\\Users\\hemag\\eclipse-workspace\\ShopManagement5\\src\\product_management\\Product.csv ");
				FileWriter fileWriter =new FileWriter(file,false);
				BufferedWriter bufferedWriter= new BufferedWriter(fileWriter);
				for(Product product:al) {
					bufferedWriter.write(product.productname+","+product.productid+","+product.productprice+","+product.productquality+","+product.productcategory+"\n");
					
				}
			
				bufferedWriter.close();
				fileWriter.close();
				file = null;
				
				System.out.println("!!! Program closed..");
				System.out.println("\n");
				canikeeprunningprogram = false;
			}
			else if(optionselectedbyproduct == ProductOptions.Add_Product) {
				addProduct();
				System.out.println("\n");
			}
			else if(optionselectedbyproduct == ProductOptions.Search_Product) {
				System.out.println("Enter the productname to Search:");
				scanner.nextLine();
				String searchproductname = scanner.nextLine();
				SearchProduct(searchproductname);
				System.out.println("\n");
			}
			else if(optionselectedbyproduct == ProductOptions.Edit_Product) {
				System.out.println("Enter the productname to Edit:");
				scanner.nextLine();
				String editproductname = scanner.nextLine();
				EditProduct(editproductname);
				System.out.println("\n");
			}
			else if(optionselectedbyproduct == ProductOptions.Delete_Product) {
				System.out.println("Enter the productname to Delete:");
				scanner.nextLine();
				String deleteproductname = scanner.nextLine();
				DeleteProduct(deleteproductname);
				System.out.println("\n");
			}
		}
		System.out.println("!!!After while loop???");
		for(Product u:al) {
			System.out.println(u.productname);
			System.out.println(u.productid);
			System.out.println(u.productprice);
			System.out.println(u.productquality);
			System.out.println(u.productcategory);
		}
	}
	public static void addProduct() {
		Scanner scanner = new Scanner(System.in) ;
			Product productObject = new Product();
			System.out.println("Product name:");
			productObject.productname =scanner.nextLine();
			System.out.println("Product Id:");
			productObject.productid =scanner.nextLine();
			System.out.println("Product price:");
			productObject.productprice = scanner.nextLine();
			System.out.println("Product Quality:");
			productObject.productquality = scanner.nextLine();
			System.out.println("Product Category:");
			productObject.productcategory = scanner.nextLine();
			
			System.out.println("Product name :"+productObject.productname);
			System.out.println("Product Id is:"+productObject.productid);
			System.out.println("Product Price:"+productObject.productprice);
			System.out.println("Product Quality:"+productObject.productquality);
			System.out.println("Product Category:"+productObject.productcategory);
			al.add(productObject);
		}
	public static void SearchProduct(String productname) {
		for(Product product:al) {
			if(product.productname.equalsIgnoreCase(productname)) {
				System.out.println("Product name:"+product.productname);
				System.out.println("Product Id:"+product.productid);
				System.out.println("Product Price:"+product.productprice);
				System.out.println("Product Quality:"+product.productquality);
				System.out.println("Product Category:"+product.productcategory);
				return;
			}
		}
		System.out.println("Product not found!!!!");
	}
	public static void EditProduct(String productname) {
		for(Product product:al) {
			if(product.productname.equalsIgnoreCase(productname)) {
				Scanner scanner = new Scanner(System.in);
				System.out.println("Editing Product:"+product.productname);
				
				System.out.println("New Product name:");
				product.productname = scanner.nextLine();
				System.out.println("New Product Id:");
				product.productid = scanner.nextLine();
				System.out.println("New Product Price:");
				product.productprice= scanner.nextLine();
				System.out.println("New Product Quality:");
				product.productquality = scanner.nextLine();
				System.out.println("New Product Category:");
				product.productcategory = scanner.nextLine();
				
				System.out.println("Product Informatin updated..");
				return;
			}
		}
		System.out.println("Product not found!!!");
	}
	public static void DeleteProduct(String productname) {
		Iterator<Product> productIterator = al.iterator();
		while(productIterator.hasNext()) {
			Product product = productIterator.next();
			if(product.productname.equalsIgnoreCase(productname)) {
				productIterator.remove();
				System.out.println("Product "+product.productname+" has been delete");
				break;
			}
		}
	}
	public static void loaddatafromfiletoArrayList() throws IOException{
		File file = new File("\\\\Users\\\\hemag\\\\eclipse-workspace\\\\ShopManagement5\\\\src\\\\product_management\\\\Product.csv  ");
		FileReader fileReader = new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		String line =" ";
		while((line= bufferedReader.readLine())!= null) {
			Product product = new Product();
			String[] productDataArray = line.split(",");
			if(productDataArray.length>4) {
				product.productname = productDataArray[0];
				product.productid = productDataArray[1];
				product.productprice = productDataArray[2];
				product.productquality = productDataArray[3];
				product.productcategory = productDataArray[4];
				
			}
		}
		fileReader.close();
		bufferedReader.close();
		file =null;
		
	}

}
