/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
/**
 *
 * @author Sarah
 */
public interface CollectionInterface<T>
{
    public abstract void addItem(T t);
    public abstract void deleteItem(int index);
    public abstract void editItem(int index, T t);    
}
