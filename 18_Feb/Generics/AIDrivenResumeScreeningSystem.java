import java.util.List;
import java.util.ArrayList;

abstract class JobRole {
    private String jobTitle;

    public JobRole(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    @Override
    public String toString() {
        return jobTitle;
    }
}

class SoftwareEngineer extends JobRole {
    public SoftwareEngineer() {
        super("Software Engineer");
    }
}

class DataScientist extends JobRole {
    public DataScientist() {
        super("Data Scientist");
    }
}

class ProductManager extends JobRole {
    public ProductManager() {
        super("Product Manager");
    }
}

class Resume<T extends JobRole> {
    private String candidateName;
    private T jobRole;

    public Resume(String candidateName, T jobRole) {
        this.candidateName = candidateName;
        this.jobRole = jobRole;
    }

    public String getCandidateName() {
        return candidateName;
    }

    public T getJobRole() {
        return jobRole;
    }

    @Override
    public String toString() {
        return candidateName + " | " + jobRole.getJobTitle();
    }
}

class ResumeScreeningSystem {

    public static void processResumes(List<Resume<? extends JobRole>> resumes) {
        for (Resume<? extends JobRole> resume : resumes) {
            System.out.println("Processing resume for: " + resume);
        }
    }

    public static void displayJobRoles(List<? extends JobRole> jobRoles) {
        for (JobRole jobRole : jobRoles) {
            System.out.println("Available job role: " + jobRole);
        }
    }
}

public class AIDrivenResumeScreeningSystem {
    public static void main(String[] args) {
        SoftwareEngineer softwareEngineer = new SoftwareEngineer();
        DataScientist dataScientist = new DataScientist();
        ProductManager productManager = new ProductManager();

        Resume<SoftwareEngineer> softwareEngineerResume = new Resume<>("John Doe", softwareEngineer);
        Resume<DataScientist> dataScientistResume = new Resume<>("Jane Smith", dataScientist);
        Resume<ProductManager> productManagerResume = new Resume<>("Emily Johnson", productManager);

        List<Resume<? extends JobRole>> resumes = new ArrayList<>();
        resumes.add(softwareEngineerResume);
        resumes.add(dataScientistResume);
        resumes.add(productManagerResume);

        ResumeScreeningSystem.processResumes(resumes);

        List<JobRole> jobRoles = new ArrayList<>();
        jobRoles.add(softwareEngineer);
        jobRoles.add(dataScientist);
        jobRoles.add(productManager);
        ResumeScreeningSystem.displayJobRoles(jobRoles);
    }
}
