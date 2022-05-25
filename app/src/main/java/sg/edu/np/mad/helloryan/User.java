package sg.edu.np.mad.helloryan;

public class User {
    public String name;
    public String description;
    public int id;
    public boolean followed;

    public User(String u, String d, int i, boolean f){b
        name = u;
        description = d;
        id = i;
        followed = f;
    }

    private int _id;
    private String _name;
    private String _description;
    private boolean _followed;

    public User(){}

    public User(String na, String de, int id, boolean fol){
        this._name = name;
        this._description = description;
        this._id = id;
        this._followed = followed;
    }

    public void setName (String name){
        this._name = name;
    }
    public String getName (){
        return (this._name);
    }
    public void setDescription (String description){
        this._description = description;
    }
    public String getDescription (){
        return (this._description);
    }
    public void setId (int id){
        this._id = id;
    }
    public int getId (){
        return (this._id);
    }
    public void setFollowed (Boolean followed){
        this._followed = followed;
    }
    public Boolean getFollowed (){
        return (this._followed);
    }



}
