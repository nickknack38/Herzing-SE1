package RestaurantManagementSystem.SpringBootExample.Model;

import RestaurantManagementSystem.SpringBootExample.Enums.FoodType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer foodId;
    private String foodTitle;
    private String foodDesc;
    @Enumerated(EnumType.STRING)
    private FoodType foodType;
    private String foodImg;
    private Double foodPrice;
    private LocalDateTime createdAt;
	public String getFoodTitle() {
		return foodTitle;
	}
	public void setFoodTitle(String foodTitle) {
		this.foodTitle = foodTitle;
	}
	public String getFoodDesc() {
		return foodDesc;
	}
	public void setFoodDesc(String foodDesc) {
		this.foodDesc = foodDesc;
	}
	public String getFoodImg() {
		return foodImg;
	}
	public void setFoodImg(String foodImg) {
		this.foodImg = foodImg;
	}
	public Double getFoodPrice() {
		return foodPrice;
	}
	public void setFoodPrice(Double foodPrice) {
		this.foodPrice = foodPrice;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	public Object getFoodType() {

		return null;
	}
	public void setFoodType(Object foodType2) {

		
	}
}