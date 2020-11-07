public class Dependent {
    Dependency dbConnection;

    Dependent(Dependency dbConnection) {
        this.dbConnection = dbConnection;
    }

    public int consolidateData(int ...varargs) {
        System.out.println("Retrieving data from the database...");
        try {
            return postProcessing(dbConnection.getDataFromDatabase(varargs));
        } catch(InterruptedException e) {
            return -1;
        }
    }

    private int postProcessing(int data) {
        System.out.println("post processing the data...");
        return data - 10;
    }
}
