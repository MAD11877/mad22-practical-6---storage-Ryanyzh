package sg.edu.np.mad.helloryan;

public class User {
    public String name;
    public String description;
    public int id;
    public boolean followed;

    public User(){}

    public User(String u, String d, int i, boolean f){
        name = u;
        description = d;
        id = i;
        followed = f;
    }
}
