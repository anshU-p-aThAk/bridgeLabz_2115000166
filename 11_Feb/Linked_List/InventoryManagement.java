class Item {
    String name;
    int itemId;
    int quantity;
    double price;
    Item next;

    public Item(int itemId, String name, int quantity, double price) {
        this.itemId = itemId;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.next = null;
    }
}

class Inventory {
    private Item head = null;

    public void addItemAtBeginning(int itemId, String name, int quantity, double price) {
        Item newItem = new Item(itemId, name, quantity, price);
        newItem.next = head;
        head = newItem;
        System.out.println("Item added at the beginning: " + name);
    }

    public void addItemAtEnd(int itemId, String name, int quantity, double price) {
        Item newItem = new Item(itemId, name, quantity, price);
        if (head == null) {
            head = newItem;
            return;
        }
        Item temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newItem;
        System.out.println("Item added at the end: " + name);
    }

    public void removeItem(int itemId) {
        if (head == null) {
            System.out.println("No items to remove.");
            return;
        }
        if (head.itemId == itemId) {
            head = head.next;
            System.out.println("Item removed: " + itemId);
            return;
        }
        Item temp = head, prev = null;
        while (temp != null && temp.itemId != itemId) {
            prev = temp;
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Item not found: " + itemId);
            return;
        }
        prev.next = temp.next;
        System.out.println("Item removed: " + itemId);
    }

    public void updateQuantity(int itemId, int newQuantity) {
        Item temp = head;
        while (temp != null) {
            if (temp.itemId == itemId) {
                temp.quantity = newQuantity;
                System.out.println("Quantity updated for Item ID: " + itemId);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item not found: " + itemId);
    }

    public void searchById(int itemId) {
        Item temp = head;
        while (temp != null) {
            if (temp.itemId == itemId) {
                System.out.println("Item Found: " + temp.name + " | ID: " + temp.itemId + " | Qty: " + temp.quantity
                        + " | Price: " + temp.price);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item not found.");
    }

    public void searchByName(String name) {
        Item temp = head;
        while (temp != null) {
            if (temp.name.equalsIgnoreCase(name)) {
                System.out.println("Item Found: " + temp.name + " | ID: " + temp.itemId + " | Qty: " + temp.quantity
                        + " | Price: " + temp.price);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item not found.");
    }

    public void calculateTotalValue() {
        double totalValue = 0;
        Item temp = head;
        while (temp != null) {
            totalValue += temp.quantity * temp.price;
            temp = temp.next;
        }
        System.out.println("Total Inventory Value: " + totalValue);
    }

    public void displayInventory() {
        if (head == null) {
            System.out.println("Inventory is empty.");
            return;
        }
        Item temp = head;
        System.out.println("Inventory List:");
        while (temp != null) {
            System.out.println("ID: " + temp.itemId + ", Name: " + temp.name + ", Qty: " + temp.quantity + ", Price: "
                    + temp.price);
            temp = temp.next;
        }
    }

    private Item mergeSortedLists(Item left, Item right, boolean sortByPrice) {
        if (left == null)
            return right;
        if (right == null)
            return left;
        Item result;
        if ((sortByPrice && left.price < right.price) || (!sortByPrice && left.name.compareTo(right.name) < 0)) {
            result = left;
            result.next = mergeSortedLists(left.next, right, sortByPrice);
        } else {
            result = right;
            result.next = mergeSortedLists(left, right.next, sortByPrice);
        }
        return result;
    }

    private Item mergeSort(Item head, boolean sortByPrice) {
        if (head == null || head.next == null)
            return head;
        Item slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Item mid = slow.next;
        slow.next = null;
        Item left = mergeSort(head, sortByPrice);
        Item right = mergeSort(mid, sortByPrice);
        return mergeSortedLists(left, right, sortByPrice);
    }

    public void sortInventory(boolean sortByPrice) {
        head = mergeSort(head, sortByPrice);
        System.out.println("Inventory sorted by " + (sortByPrice ? "Price" : "Name") + ".");
    }
}

public class InventoryManagement {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        inventory.addItemAtBeginning(1, "Laptop", 10, 50000);
        inventory.addItemAtEnd(2, "Mouse", 50, 500);
        inventory.addItemAtEnd(3, "Keyboard", 30, 1500);
        inventory.addItemAtBeginning(4, "Monitor", 15, 12000);

        inventory.displayInventory();
        inventory.updateQuantity(2, 60);
        inventory.searchById(3);
        inventory.searchByName("Laptop");
        inventory.calculateTotalValue();

        inventory.sortInventory(false);
        inventory.displayInventory();

        inventory.removeItem(4);
        inventory.displayInventory();
    }
}
