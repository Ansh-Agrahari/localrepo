public class Controller {
    private String modelType;
    private double[] inputFeatures;
    private double threshold;
    private String prediction;

    public Controller() {
        this.modelType = "TypeB";
        this.threshold = 0.5;
        this.prediction = "Unknown";
    }

    public Controller(String modelType, double threshold) {
        this.modelType = modelType;
        this.threshold = threshold;
        this.prediction = "Unknown";
    }

    public void setInputFeatures(double[] features) {
        if (features == null || features.length == 0) {
            throw new IllegalArgumentException("Input features cannot be null or empty.");
        }
        this.inputFeatures = features.clone();
    }

    public double[] getInputFeatures() {
        return inputFeatures == null ? null : inputFeatures.clone();
    }

    public String getPrediction() {
        return prediction;
    }

    public boolean validateInput() {
        if (inputFeatures == null || inputFeatures.length == 0) {
            return false;
        }
        for (double value : inputFeatures) {
            if (Double.isNaN(value) || Double.isInfinite(value)) {
                return false;
            }
        }
        return true;
    }

    public void computePrediction() {
        if (!validateInput()) {
            throw new IllegalStateException("Input data is invalid. Cannot compute prediction.");
        }

        double score = 0.0;
        for (double value : inputFeatures) {
            score += normalize(value);
        }
        score /= inputFeatures.length;

        if (modelType.equalsIgnoreCase("TypeB") && score >= threshold) {
            prediction = "MBM";
        } else {
            prediction = "No MBM";
        }
    }

    private double normalize(double value) {
        // Simple normalization for intermediate predictor logic.
        return (value + 1.0) / 2.0;
    }

    public static void main(String[] args) {
        Controller controller = new Controller();
        controller.setInputFeatures(new double[] {0.2, 0.7, 0.4});
        controller.computePrediction();
        System.out.println("Model Type: " + controller.modelType);
        System.out.println("Prediction: " + controller.getPrediction());
    }
}
