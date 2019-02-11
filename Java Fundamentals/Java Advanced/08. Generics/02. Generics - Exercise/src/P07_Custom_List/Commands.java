package P07_Custom_List;

public class Commands {
    private CustomList customList;
    private String command;

    public Commands() {
        this.customList = new CustomList();
        this.command = "";
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public void execute(){
        String[] command = this.command.split(" ");

        switch (command[0]){
            case "Add":
                this.customList.add(command[1]);
                break;
            case "Remove":
                this.customList.remove(Integer.parseInt(command[1]));
                break;
            case "Contains":
                System.out.println(this.customList.contains(command[1]));
                break;
            case "Swap":
                int index = Integer.parseInt(command[1]);
                int index2 = Integer.parseInt(command[2]);
                this.customList.swap(index, index2);
                break;
            case "Greater":
                System.out.println(this.customList.countGreater(command[1]));
                break;
            case "Max":
                System.out.println(this.customList.max());
                break;
            case "Min":
                System.out.println(this.customList.min());
                break;
            case "Print":
                this.customList.forEach(System.out::println);
                break;
        }
    }
}
