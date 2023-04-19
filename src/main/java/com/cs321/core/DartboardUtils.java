package com.cs321.core;

/**
 * Provides utility methods for calculating the score of a dartboard.
 * 
 * @author James Luna, Hasnain Raza, Marouane Guerouji
 */
public class DartboardUtils {

    // The following constants are in millimeters from https://www.dimensions.com/element/dartboard
    // private static final float BullseyeRadius = 6.35f;
    // private static final float BullseyeRingRadius = 16.0f;
    // private static final float TripleRingInnerRadius = 99.0f;
    // private static final float TripleRingOuterRadius = 107.0f;
    // private static final float DoubleRingInnerRadius = 162.0f;
    // private static final float DoubleRingOuterRadius = 170.0f;
    // private static final float DartboardRadius = 225.5f;

    // Custom adjusted constants for the dartboard.
    private static final float BullseyeRadius = 8.0f;
    private static final float BullseyeRingRadius = 14.0f;
    private static final float TripleRingInnerRadius = 86.0f;
    private static final float TripleRingOuterRadius = 96.0f;
    private static final float DoubleRingInnerRadius = 142.0f;
    private static final float DoubleRingOuterRadius = 152.0f;
    private static final float DartboardRadius = 200.0f;

    // The following constants are normalized to the radius of the dartboard.
    private static final float BullseyeRadiusNormalized = BullseyeRadius / DartboardRadius;
    private static final float BullseyeRingRadiusNormalized = BullseyeRingRadius / DartboardRadius;
    private static final float TripleRingInnerRadiusNormalized = TripleRingInnerRadius / DartboardRadius;
    private static final float TripleRingOuterRadiusNormalized = TripleRingOuterRadius / DartboardRadius;
    private static final float DoubleRingInnerRadiusNormalized = DoubleRingInnerRadius / DartboardRadius;
    private static final float DoubleRingOuterRadiusNormalized = DoubleRingOuterRadius / DartboardRadius;
    private static final float DartboardRadiusNormalized = 1.0f;

    /**
     * Uses the normalized coordinates and the GameConfiguration to determine the
     * total score for the dart.
     * 
     * @param nx the normalized coordinate for the x value.
     * @param ny the normalized coordinate for the y value.
     * @param gameConfiguration the GameConfiguration to use.
     * @return a rounded down version of the score with an applied multiplier.
     */
    public static int getTotalScore(float nx, float ny, GameConfiguration gameConfiguration) {
        // Transform the coordinates
        nx = (nx - 0.5f) * 2.0f;
        ny = ((1 - ny) - 0.5f) * 2.0f;

        int multiplerIndex = coordsToMultiplier(nx, ny);
        int scoreIndex = coordsToScore(nx, ny);

        float multiplier = 1.0f;
        float score = gameConfiguration.getOffboardPenalty();

        if (multiplerIndex != -1) {
            multiplier = gameConfiguration.getMultipliers()[multiplerIndex];
        }
        if (scoreIndex != -1) {
            score = gameConfiguration.getScoreList()[scoreIndex];
        }

        return (int) (Math.floor(score * multiplier));
    }

    /**
     * Gets the index in scoreList based on where the player hit.
     * 
     * @param nx the normalized coordinate for the x value.
     * @param ny the normalized coordinate for the y value.
     * @return an int representing an index in GameConfiguration scoreList.
     */
    public static int coordsToScore(float nx, float ny) {
        float magnitude = getMagnitudeFromCoordinates(nx, ny);
        float angle = getAngleFromCoordinates(nx, ny);
        int sectionPosition = (int) ((angle - 9.0f) / 18.0f);

        if (magnitude < BullseyeRingRadiusNormalized) {
            return 20;
        } else if (magnitude >= DoubleRingOuterRadiusNormalized) {
            return -1;
        } else if ((angle > 0.0f && angle <= 9.0f) || (angle > 351 || angle == 0)) {
            return 5;
        }

        switch (sectionPosition) {
            case (0):
                return 12;
            case (1):
                return 3;
            case (2):
                return 17;
            case (3):
                return 0;
            case (4):
                return 19;
            case (5):
                return 4;
            case (6):
                return 11;
            case (7):
                return 8;
            case (8):
                return 13;
            case (9):
                return 10;
            case (10):
                return 7;
            case (11):
                return 15;
            case (12):
                return 6;
            case (13):
                return 18;
            case (14):
                return 2;
            case (15):
                return 16;
            case (16):
                return 1;
            case (17):
                return 14;
            default:
                return 9;
        }
    }
    
    /**
     * Gets the index in multipliers based on where the player hit.
     * 
     * @param nx the normalized coordinate for the x value.
     * @param ny the normalized coordinate for the y value.
     * @return an int representing an index in gameConfigurations multiplers, -1 for no multiplier.
     */
    public static int coordsToMultiplier(float nx, float ny) {
        float magnitude = getMagnitudeFromCoordinates(nx, ny);
        if (magnitude > BullseyeRadiusNormalized && magnitude < BullseyeRingRadiusNormalized) {
            return 2;
        } else if (magnitude > TripleRingInnerRadiusNormalized && magnitude < TripleRingOuterRadiusNormalized) {
            return 1;
        } else if (magnitude > DoubleRingInnerRadiusNormalized && magnitude < DoubleRingOuterRadiusNormalized) {
            return 0;
        } else {
            return -1;
        }
    }
    
    /**
     * Gets the angle of the coordinates based on where the player hit.
     * 
     * @param nx the normalized coordinate for the x value.
     * @param ny the normalized coordinate for the y value.
     * @return an float representing the angel formed by where the player hit.
     */
    private static float getAngleFromCoordinates(float nx, float ny) {
        float angle = (float) Math.atan2(ny, nx);
        angle = (float) Math.toDegrees(angle);

        // https://stackoverflow.com/questions/1311049/how-to-map-atan2-to-degrees-0-360
        angle = (angle + 360.0f) % 360.0f;
        
        return angle;
    }

    /**
     * Gets the magnitude of the coordinates.
     * 
     * @param nx the normalized coordinate for the x value.
     * @param ny the normalized coordinate for the y value.
     * @return a float representing the magnitude of the coordinates.
     */
    private static float getMagnitudeFromCoordinates(float nx, float ny) {
        return (float) Math.sqrt(nx * nx + ny * ny);
    }
}
