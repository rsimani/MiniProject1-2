package renderer;

import primitives.*;
import scene.*;

/**
 * Abstract class to find the intersections of ray with the scene
 */
public abstract class RayTracerBase {
    /**
     * scene for raytracer
     */
    protected Scene scene;

    /**
     * CTOR
     *
     * @param scene Our scene
     */
    public RayTracerBase(Scene scene) {
        this.scene = scene;
    }

    /**
     * abstract trace ray function
     *
     * @param ray 3D ray
     *
     * @return color
     */
    abstract Color traceRay(Ray ray);
}