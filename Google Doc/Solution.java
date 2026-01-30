import java.util.ArrayList;
import java.util.List;

/* ===== Persistence Layer ===== */

interface Persistent {
    void save(Document doc);
    Document load(int id);
}

interface Backupable {
    void backup(Document doc);
}

class FileStorage implements Persistent {
    @Override
    public void save(Document doc) {
        System.out.println("Document saved to File");
    }

    @Override
    public Document load(int id) {
        System.out.println("Document loaded from File");
        return new Document();
    }
}

class DBStorage implements Persistent {
    @Override
    public void save(Document doc) {
        System.out.println("Document saved to DB");
    }

    @Override
    public Document load(int id) {
        System.out.println("Document loaded from DB");
        return new Document();
    }
}

class CloudStorage implements Persistent, Backupable {
    @Override
    public void save(Document doc) {
        System.out.println("Document saved to Cloud");
    }

    @Override
    public Document load(int id) {
        System.out.println("Document loaded from Cloud");
        return new Document();
    }

    @Override
    public void backup(Document doc) {
        System.out.println("Document backup completed");
    }
}

/* ===== Document Model ===== */

class Document {
    private List<DocumentElement> elements = new ArrayList<>();

    public void addElement(DocumentElement element) {
        elements.add(element);
    }

    public void removeElement(int index) {
        elements.remove(index);
    }

    public List<DocumentElement> getElements() {
        return elements;
    }
}

interface DocumentElement {
    void render();
}

class TextElement implements DocumentElement {
    @Override
    public void render() {
        System.out.println("Rendering Text");
    }
}

class ImageElement implements DocumentElement {
    @Override
    public void render() {
        System.out.println("Rendering Image");
    }
}

/* ===== Editor & Viewer ===== */

interface DocumentEditor {
    void edit(Document doc);
}

interface DocumentViewer {
    void view(Document doc);
}

class SimpleDocumentEditor implements DocumentEditor {
    @Override
    public void edit(Document doc) {
        doc.addElement(new TextElement());
        System.out.println("Text added to document");
    }
}

class SimpleDocumentViewer implements DocumentViewer {
    @Override
    public void view(Document doc) {
        for (DocumentElement element : doc.getElements()) {
            element.render();
        }
    }
}

/* ===== Client ===== */

class Client {
    private final Persistent persistent;
    private final DocumentEditor editor;
    private final DocumentViewer viewer;

    Client(Persistent persistent, DocumentEditor editor, DocumentViewer viewer) {
        this.persistent = persistent;
        this.editor = editor;
        this.viewer = viewer;
    }

    public void createAndUseDocument() {
        Document doc = new Document();
        editor.edit(doc);
        viewer.view(doc);
        persistent.save(doc);
    }
}

/* ===== Main ===== */

public class Solution {
    public static void main(String[] args) {
        Persistent storage = new CloudStorage();
        DocumentEditor editor = new SimpleDocumentEditor();
        DocumentViewer viewer = new SimpleDocumentViewer();

        Client client = new Client(storage, editor, viewer);
        client.createAndUseDocument();
    }
}