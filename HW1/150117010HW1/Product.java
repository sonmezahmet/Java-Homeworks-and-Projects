import java.util.Calendar;

/*
• Each Product has a name, saleDate and price data fields.
• There are setter/getter and toString() methods.
*/

public class Product {
	private String productName;
	private java.util.Calendar saleDate;
	private double price;
	
	public Product(String sName, java.util.Calendar sDate, double price) throws Exception {
		setProductName(sName);
		saleDate = sDate;
		setPrice(price);
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) throws Exception {
		if (productName.length() < 3) {
			throw new Exception("Invalid productName");
		}
		else {
			this.productName = productName;
		}
	}

	public java.util.Calendar getSaleDate() {
		return saleDate;
	}

	public void setSaleDate(java.util.Calendar saleDate) {
		this.saleDate = saleDate;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) throws Exception {
		if (price < 0) {
			throw new Exception("Invalid price");
		}
		else {
			this.price = price;
		}
	}

	@Override
	public String toString() {
		if (saleDate.get(Calendar.MONTH) == 12) {
			return "Product [productName=" + productName + ", saleDate=" + saleDate.get(Calendar.DATE) + "/" + (saleDate.get(Calendar.MONTH) + 12) + "/" + (saleDate.get(Calendar.YEAR) - 1) + ", price=" + price + "]";
		}
		else {
			return "Product [productName=" + productName + ", saleDate=" + saleDate.get(Calendar.DATE) + "/" + saleDate.get(Calendar.MONTH) + "/" + saleDate.get(Calendar.YEAR) + ", price=" + price + "]";
		}
	}
}
