public class Group {

    private int person;

    public Group(int person) throws Exception {
        checkPerson(person);
        this.person = person;
    }

    private void checkPerson(int person) throws Exception {
        if (person <= 0) throw new Exception();

    }

    public int getPerson() {
        return person;
    }

    @Override
    public String toString() {
        return "Group{" +
                "person=" + person +
                '}';
    }

    public void setPerson(int person) {
        this.person = person;
    }
}