package Question3;

public class Student extends IdObject {
    
    private final String name; 
    private final int[] preferenceProgramIDs;
    
    public Student(String name, int[] preferenceProgramIDs) {
        if(preferenceProgramIDs.length!=5)throw new IllegalArgumentException("Enter exact 5 preferences");
        for(int programId: preferenceProgramIDs)
            if(programId<1)throw new IllegalArgumentException("Program Id can't be less than 1"); 
        this.name = name;
        this.preferenceProgramIDs = preferenceProgramIDs;
    } 

    public String getName() {
        return name;
    }

    public int[] getPreferenceProgramIDs() {
        return preferenceProgramIDs;
    }
}