package decorator.originalproblem;

// PROBLEM: This class owns every transformation step.
// Adding a new transformation (e.g. base64 encoding, digital signature)
// requires modifying this class, adding a new constructor flag, a new if-block,
// and retesting every existing combination.
// The transformation order is also fixed — callers cannot control it.
// Each step is untestable in isolation because it is buried inside this method.
public class DocumentExporter {

    private final boolean compress;
    private final boolean encrypt;
    private final boolean watermark;

    public DocumentExporter(boolean compress, boolean encrypt, boolean watermark) {
        this.compress = compress;
        this.encrypt = encrypt;
        this.watermark = watermark;
    }

    public String export(Document document) {
        String result = document.getContent();

        if (compress) {
            result = "[COMPRESSED]{" + result + "}";
        }

        if (encrypt) {
            result = "[ENCRYPTED]{" + result + "}";
        }

        if (watermark) {
            result = result + " -- CONFIDENTIAL: " + document.getTitle();
        }

        return result;
    }
}
