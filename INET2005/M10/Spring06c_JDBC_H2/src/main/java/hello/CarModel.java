package hello;

/**
 *  This class sets up the data used, a car model has ID, name, and number
 *
 *  Note the use of constructors and getters/setters.  Spring needs to
 *  auto-find these methods to operate on the class's data fields.
 */
public class CarModel {

    private long id;
    private String modelName;
    private Integer modelNumber;

    public CarModel() {
        this.setId(0);
        this.setModelName("default modelName");
        this.setModelNumber(0);
    }

    public CarModel(long id, String modelName, Integer modelNumber) {
        this.setId(id);
        this.setModelName(modelName);
        this.setModelNumber(modelNumber);
    }

    @Override
    public String toString() {
        return "CarModel{" +
                "id=" + getId() +
                ", modelName='" + getModelName() + '\'' +
                ", modelNumber=" + getModelNumber();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public Integer getModelNumber() {
        return modelNumber;
    }

    public void setModelNumber(Integer modelNumber) {
        this.modelNumber = modelNumber;
    }


// getters & setters omitted for brevity

}

