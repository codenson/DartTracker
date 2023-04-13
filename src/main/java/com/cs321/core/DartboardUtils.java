package com.cs321.core;

/**
 * Provides Utility methods for calculating the score of a dartboard.
 * 
 * @author James Luna, Hasnain Raza, Marouane Guerouji
 */
public class DartboardUtils {

    private static final float BullseyeRadius = 6.35f;
    private static final float BullseyeRingRadius = 16.0f;
    private static final float TripleRingInnerRadius = 99.0f;
    private static final float TripleRingOuterRadius = 107.0f;
    private static final float DoubleRingInnerRadius = 162.0f;
    private static final float DoubleRingOuterRadius = 170.0f;
    private static final float DartboardRadius = 225.5f;

    private static final float BullseyeRadiusNormalized = BullseyeRadius / DartboardRadius;
    private static final float BullseyeRingRadiusNormalized = BullseyeRingRadius / DartboardRadius;
    private static final float TripleRingInnerRadiusNormalized = TripleRingInnerRadius / DartboardRadius;
    private static final float TripleRingOuterRadiusNormalized = TripleRingOuterRadius / DartboardRadius;
    private static final float DoubleRingInnerRadiusNormalized = DoubleRingInnerRadius / DartboardRadius;
    private static final float DoubleRingOuterRadiusNormalized = DoubleRingOuterRadius / DartboardRadius;
    private static final float DartboardRadiusNormalized = 1.0f;

    public static int size_of_bullseye;

    /**
     * Gets the total score for the user with an applied
     * 
     * @param nx the normalized coordinate for the x value.
     * @param ny the normalized coordinate for the y value.
     * @param gameConfiguration the configuration for the current game.
     * @return a rounded down version of the score with an applied multiplier.
     */
    public static int getTotalScore(float nx, float ny, GameConfiguration gameConfiguration) {
        int location_of_multiplier = coordsToMultiplier(nx, ny);
        int location_of_score = coordsToScore(nx, ny);
        float multiplier = 1.0f;
        float score = gameConfiguration.getOffboardPenalty();
        if(location_of_multiplier!=-1)
        {
            multiplier=gameConfiguration.getMultipliers()[location_of_multiplier];
        }
        if(location_of_score!=-1)
        {
            score=gameConfiguration.getScoreList()[coordsToScore(nx, ny)];
        }
        return (int)(Math.floor(score*multiplier));
    }

    /**
     * Gets the index in scoreList based on where the player hit.
     * 
     * @param nx the normalized coordinate for the x value.
     * @param ny the normalized coordinate for the y value.
     * @return an int representing an index in gameConfigurations scoreList.
     */
    public static int coordsToScore(float nx, float ny)
    {
        float mag = getMagnitudeFromCoordinates(nx, ny);
        float angle = getAngleFromCoordinates(nx, ny);
        int pos = (int) ((angle - 9.0f) / 18.0f);
        if(mag<BullseyeRadiusNormalized)
        {
            return 20;
        }
        else if(mag>=DartboardRadius) {
            return -1;
        }
        else if((angle>0.0f&&angle<=9.0f)||(angle>351||angle==0))
        {
            return 5;
        }
        switch(pos)
        {
            case(0):
                return 12;
            case(1):
                return 3;
            case(2):
                return 17;
            case(3):
                return 0;
            case(4):    
                return 19;
            case(5):                    
                return 4;
            case(6):    
                return 11;
            case(7):
                return 8;
            case(8):
                return 13;
            case(9):
                return 10;
            case(10):
                return 7;
            case(11):
                return 15;
            case(12):
                return 6;
            case(13):
                return 18;
            case(14):
                return 2;
            case(15):
                return 16;
            case(16):
                return 1;
            case(17):
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
    public static int coordsToMultiplier(float nx, float ny)
    {
        float magnitude = getMagnitudeFromCoordinates(nx, ny);
        if (magnitude > BullseyeRadiusNormalized && magnitude < BullseyeRadiusNormalized) {
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
        float angle = (float) Math.atan2(ny - 0.5, nx - 0.5);
        angle = (float) Math.toDegrees(angle);

        // https://stackoverflow.com/questions/1311049/how-to-map-atan2-to-degrees-0-360
        angle = (angle + 360.0f) % 360.0f;
        
        return angle;
    }

    /**
     * Gets the magnitude from the center to where the player hit.
     * 
     * @param nx the normalized coordinate for the x value.
     * @param ny the normalized coordinate for the y value.
     * @return a float representing the magnitude from the center to where the player hit.
     */
    private static float getMagnitudeFromCoordinates(float nx, float ny) {
        return (float) Math.sqrt((nx - 0.5) * (nx - 0.5) + (ny - 0.5) * (ny - 0.5));
    }
}
