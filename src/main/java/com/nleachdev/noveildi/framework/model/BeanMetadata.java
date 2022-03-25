package com.nleachdev.noveildi.framework.model;

import java.util.Objects;
import java.util.StringJoiner;

public class BeanMetadata extends Metadata {
    private final InjectionPoint injectionPoint;

    public BeanMetadata(final Class<?> type, final String beanName, final InjectionPoint injectionPoint) {
        super(type, beanName, BeanType.COMPONENT);
        this.injectionPoint = injectionPoint;
    }

    protected BeanMetadata(final Class<?> type, final String beanName, final InjectionPoint injectionPoint,
                           final BeanType beanType) {
        super(type, beanName, beanType);
        this.injectionPoint = injectionPoint;
    }

    @Override
    protected Object createInstance(final Object... args) {
        return null;
    }

    public InjectionPoint getInjectionPoint() {
        return injectionPoint;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof BeanMetadata)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        final BeanMetadata metadata = (BeanMetadata) o;
        return Objects.equals(injectionPoint, metadata.injectionPoint);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), injectionPoint);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", BeanMetadata.class.getSimpleName() + "[", "]")
                .add("classInjectionPoint=" + injectionPoint)
                .add("type=" + type)
                .add("beanName='" + beanName + "'")
                .add("beanType=" + beanType)
                .add("dependencyCost=" + dependencyCost)
                .add("instance=" + instance)
                .add("interfaces=" + interfaces)
                .toString();
    }
}
/*
public class BeanMetadata implements Comparator<BeanMetadata> {
    private final Class<?> type;
    private final String beanName;
    private final BeanType beanType;
    private final ClassInjectionPoint injectionPoint;
    private int dependencyCost;
    private Object instance;
    private final Set<Class<?>> interfaces;

    public BeanMetadata(final Class<?> type, final String beanName, final BeanType beanType, final ClassInjectionPoint injectionPoint,
                        final Set<Class<?>> interfaces) {
        this.type = type;
        this.beanName = beanName;
        this.beanType = beanType;
        this.injectionPoint = injectionPoint;
        this.interfaces = interfaces;
    }

    @Override
    public int compare(final BeanMetadata o1, final BeanMetadata o2) {
        return Integer.compare(o1.dependencyCost, o2.dependencyCost);
    }

    public Class<?> getType() {
        return type;
    }

    public String getBeanName() {
        return beanName;
    }

    public BeanType getBeanType() {
        return beanType;
    }

    public ClassInjectionPoint getInjectionPoint() {
        return injectionPoint;
    }

    public int getDependencyCost() {
        return dependencyCost;
    }

    public Object getInstance() {
        return instance;
    }

    public Set<Class<?>> getInterfaces() {
        return interfaces;
    }

    public void setDependencyCost(final int dependencyCost) {
        this.dependencyCost = dependencyCost;
    }

    public void setInstance(final Object instance) {
        this.instance = instance;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final BeanMetadata metadata = (BeanMetadata) o;
        return dependencyCost == metadata.dependencyCost &&
                Objects.equals(type, metadata.type) &&
                Objects.equals(beanName, metadata.beanName) &&
                beanType == metadata.beanType &&
                Objects.equals(injectionPoint, metadata.injectionPoint) &&
                Objects.equals(instance, metadata.instance) &&
                Objects.equals(interfaces, metadata.interfaces);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, beanName, beanType, injectionPoint, dependencyCost, instance, interfaces);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", BeanMetadata.class.getSimpleName() + "[", "]")
                .add("type=" + type)
                .add("beanName='" + beanName + "'")
                .add("beanType=" + beanType)
                .add("injectionPoint=" + injectionPoint)
                .add("dependencyCost=" + dependencyCost)
                .add("instance=" + instance)
                .add("interfaces=" + interfaces)
                .toString();
    }
}
*/
