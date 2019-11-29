package hello;

public class CarModel {

    private long id;
    private String modelName;
    private Integer modelNumber;


    public CarModel(long id, String modelName, Integer modelNumber) {
        this.id = id;
        this.modelName = modelName;
        this.modelNumber = modelNumber;
    }

    @Override
    public String toString() {
        return "CarModel{" +
                "id=" + id +
                ", modelName='" + modelName + '\'' +
                ", modelNumber=" + modelNumber;
    }


// getters & setters omitted for brevity

}

