package ua.edu.ucu.collections.immutable;


public class ImmutableArrayList implements ImmutableList {
    private Object[] objectsArray;

    public ImmutableArrayList(Object[] objects) {
        Object[] newObjectsArray = new Object[objects.length];

        int counter = 0;
        for (Object obj: objects) {
            newObjectsArray[counter] = obj;
            counter++;
        }

        this.objectsArray = newObjectsArray;
    }

    @Override
    public ImmutableList add(Object e) {
        return add(objectsArray.length, e);
    }

    @Override
    public ImmutableList add(int index, Object e) {
        return addAll(index, new Object[] {e});
    }

    @Override
    public ImmutableList addAll(Object[] c) {
        return addAll(objectsArray.length, c);
    }

    private int addElementsAtPositionIfNeeded(int counter, int index,
                                              Object[] newObjectsArray, Object[] c) {
        int i = counter;
        if (i == index) {
            // inserting as last elements!
            for (Object objNew: c) {
                newObjectsArray[i] = objNew;
                i++;
            }
        }
        return i;
    }

    @Override
    public ImmutableList addAll(int index, Object[] c) {
        if (index > objectsArray.length) {
            throw new IndexOutOfBoundsException();
        }

        Object[] newObjectsArray = new Object[objectsArray.length + c.length];

        int counter = 0;
        for (Object obj: objectsArray) {
            counter = addElementsAtPositionIfNeeded(
                    counter, index, newObjectsArray, c);
            newObjectsArray[counter] = obj;
            counter++;
        }
        addElementsAtPositionIfNeeded(counter, index, newObjectsArray, c);

        return new ImmutableArrayList(newObjectsArray);
    }

    @Override
    public Object get(int index) {
        if (index >= objectsArray.length) {
            throw new IndexOutOfBoundsException();
        }

        return objectsArray[index];
    }

    @Override
    public ImmutableList remove(int index) {
        if (index > objectsArray.length) {
            throw new IndexOutOfBoundsException();
        }

        Object[] newObjectsArray = new Object[objectsArray.length - 1];

        int counter = 0;
        int takeIndex = 0;
        for (Object obj: objectsArray) {
            if (counter == index) {
                // Just skip this element as we need to remove it
                counter++;
                continue;
            }
            newObjectsArray[takeIndex] = obj;
            counter++;
            takeIndex++;
        }
        return new ImmutableArrayList(newObjectsArray);
    }

    @Override
    public ImmutableList set(int index, Object e) {
        if (index > objectsArray.length) {
            throw new IndexOutOfBoundsException();
        }

        Object[] newObjectsArray = new Object[objectsArray.length];

        int counter = 0;
        for (Object obj: objectsArray) {
            if (counter == index) {
                newObjectsArray[counter] = e;
                counter++;
                continue;
            }
            newObjectsArray[counter] = obj;
            counter++;
        }
        return new ImmutableArrayList(newObjectsArray);
    }

    @Override
    public int indexOf(Object e) {
        int counter = 0;
        for (Object obj: objectsArray) {
            if (obj.equals(e)) {
                return counter;
            }
            counter++;
        }
        return -1;
    }

    @Override
    public int size() {
        return objectsArray.length;
    }

    @Override
    public ImmutableList clear() {
        return new ImmutableArrayList(new Object[0]);
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public Object[] toArray() {
        Object[] newObjectsArray = new Object[objectsArray.length];

        int counter = 0;
        for (Object obj: objectsArray) {
            newObjectsArray[counter] = obj;
            counter++;
        }

        return newObjectsArray;
    }
}
