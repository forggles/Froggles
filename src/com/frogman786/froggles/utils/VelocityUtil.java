package com.frogman786.froggles.utils;

import org.bukkit.Location;
import org.bukkit.util.Vector;

import com.frogman786.froggles.Froggles;

public class VelocityUtil
{
    public static Vector calculateVelocity(Vector from, Vector to, int heightGain)
    {
        // Gravity of object (player)
        double gravity = Froggles.gravity;
 
        // Block locations
        int endGain = to.getBlockY() - from.getBlockY();
        double horizDist = Math.sqrt(distanceSquared(from, to));
 
        // Height gain
        int gain = heightGain;
 
        double maxGain = gain > (endGain + gain) ? gain : (endGain + gain);
 
        // Solve quadratic equation for velocity
        double a = -horizDist * horizDist / (4 * maxGain);
        double b = horizDist;
        double c = -endGain;
 
        double slope = -b / (2 * a) - Math.sqrt(b * b - 4 * a * c) / (2 * a);
 
        // Vertical velocity
        double vy = Math.sqrt(maxGain * gravity);
 
        // Horizontal velocity
        double vh = vy / slope;
 
        // Calculate horizontal direction
        int dx = to.getBlockX() - from.getBlockX();
        int dz = to.getBlockZ() - from.getBlockZ();
        double mag = Math.sqrt(dx * dx + dz * dz);
        double dirx = dx / mag;
        double dirz = dz / mag;
 
        // Horizontal velocity components
        double vx = vh * dirx;
        double vz = vh * dirz;
 
        return new Vector(vx, vy, vz);
    }
 
    private static double distanceSquared(Vector from, Vector to)
    {
        double dx = to.getBlockX() - from.getBlockX();
        double dz = to.getBlockZ() - from.getBlockZ();
 
        return dx * dx + dz * dz;
    }
    public static Vector twopoints(Location first_location,Location second_location){
    	double dX = first_location.getX() - second_location.getX();
    	double dY = first_location.getY() - second_location.getY();
    	double dZ = first_location.getZ() - second_location.getZ();
    	double yaw = Math.atan2(dZ, dX);
    	double pitch = Math.atan2(Math.sqrt(dZ * dZ + dX * dX), dY) + Math.PI;
    	double X = Math.sin(pitch) * Math.cos(yaw);
    	double Y = Math.sin(pitch) * Math.sin(yaw);
    	double Z = Math.cos(pitch); 
    	return new Vector(X, Z, Y);
    }
}