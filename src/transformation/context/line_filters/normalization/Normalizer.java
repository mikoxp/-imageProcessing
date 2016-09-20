package transformation.context.line_filters.normalization;

import java.awt.*;

/**
 * Created by moles on 20.09.2016.
 * @author moles
 */
public interface Normalizer {
    /**
     *
     * @param red red part color before normalization
     * @param green green part color before normalization
     * @param blue blue part color before normalization
     * @return Color after normalization
     */
    public Color normalizing(int red, int green, int blue);
}
