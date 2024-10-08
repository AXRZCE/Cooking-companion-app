package com.example.cookingcompanionapp;

import android.os.Parcel;
import android.os.Parcelable;

public class Recipe implements Parcelable {
    private String title;
    private int imageResourceId;
    private String ingredients;
    private String instructions;

    public Recipe(String title, int imageResourceId, String ingredients, String instructions) {
        this.title = title;
        this.imageResourceId = imageResourceId;
        this.ingredients = ingredients;
        this.instructions = instructions;
    }

    public String getTitle() {
        return title;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public String getIngredients() {
        return ingredients;
    }

    public String getInstructions() {
        return instructions;
    }

    // Parcelable implementation
    protected Recipe(Parcel in) {
        title = in.readString();
        imageResourceId = in.readInt();
        ingredients = in.readString();
        instructions = in.readString();
    }

    public static final Creator<Recipe> CREATOR = new Creator<Recipe>() {
        @Override
        public Recipe createFromParcel(Parcel in) {
            return new Recipe(in);
        }

        @Override
        public Recipe[] newArray(int size) {
            return new Recipe[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeInt(imageResourceId);
        dest.writeString(ingredients);
        dest.writeString(instructions);
    }
}