package P04_Word;

public class CutTransform implements TextTransform {
    private StringBuilder buffer;

    @Override
    public void invokeOn(StringBuilder text, int startIndex, int endIndex) {
        this.buffer = new StringBuilder();
        this.buffer.append(text, startIndex, endIndex);
        text.delete(startIndex, endIndex);
    }

    public StringBuilder getBuffer() {
        return buffer;
    }
}
