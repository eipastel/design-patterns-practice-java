# The Problem — Before Decorator

## Context

A document management system needs to export documents with optional post-processing steps: compression, encryption, and watermarking. Each export request may require a different combination of these transformations depending on the document type and destination (internal share, external client, regulatory archive, etc.).

## What's wrong here

A single `DocumentExporter` class receives boolean flags for each transformation and applies them in a fixed order inside a chain of `if` blocks. Every new transformation (e.g. base64 encoding, digital signature, header injection) requires modifying this class — adding a new flag, a new `if` block, and retesting every existing combination.

### Direct consequences

1. **Open/Closed violation**: adding a new transformation always means editing `DocumentExporter`, risking regressions in existing combinations.
2. **Fixed order**: the transformation order is hardcoded inside the method. A client that needs encrypt-then-compress gets the same order as one that needs compress-then-encrypt — no way to control it without more flags.
3. **Untestable in isolation**: you cannot test the encryption logic without instantiating `DocumentExporter` and toggling the right flags. Each transformation is buried inside a method with no clear boundary.
4. **Combinatorial documentation burden**: callers must understand which flag combinations are valid. Invalid combinations (e.g. watermark on an already-encrypted binary) are silently allowed.

## Files

- `Document.java` — simple data class representing a document with a title and text content.
- `DocumentExporter.java` — the God class. Receives three boolean flags in the constructor and applies the transformations inside a single `export()` method using nested `if` blocks.
