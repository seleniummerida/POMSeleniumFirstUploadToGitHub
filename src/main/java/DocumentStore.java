import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.*;
	
public class DocumentStore {

	private Collection<String> documents = new ArrayList<String>();
    private int capacity;

    public DocumentStore(int capacity) {
        this.capacity = capacity;
    }

    public int getCapacity() { 
      return this.documents.size();
    }

    public Collection<String> getDocuments() {
      return this.documents; 
    }

    public void addDocument(String document) {
        System.out.println(getCapacity());
    	if (getCapacity() <= this.capacity)
        {
        	this.documents.add(document);
        }
        else
        {        	
                throw new IllegalStateException();

        }
    }
    
    @Override 
    public String toString() {
        return String.format("Document store: %d/%d", this.documents.size(), this.capacity);
    }
    
    public static void main(String[] args) {
        DocumentStore documentStore = new DocumentStore(0);
        for (int i=0; i<2; i++)
        {
        	documentStore.addDocument("item");
        	System.out.println(documentStore);
        }
    }
}
