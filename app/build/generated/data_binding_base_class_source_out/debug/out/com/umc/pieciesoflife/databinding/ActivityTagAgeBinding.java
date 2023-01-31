// Generated by view binder compiler. Do not edit!
package com.umc.pieciesoflife.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.umc.pieciesoflife.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityTagAgeBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final ImageButton buttonBack;

  @NonNull
  public final Button buttonGuide;

  @NonNull
  public final Button buttonNext;

  @NonNull
  public final Button buttonSkipQuestion;

  @NonNull
  public final EditText editTextAge;

  @NonNull
  public final TextView textView1;

  @NonNull
  public final TextView textView2;

  @NonNull
  public final TextView textView3;

  @NonNull
  public final TextView textViewAge;

  @NonNull
  public final TextView textViewGuide;

  private ActivityTagAgeBinding(@NonNull ConstraintLayout rootView, @NonNull ImageButton buttonBack,
      @NonNull Button buttonGuide, @NonNull Button buttonNext, @NonNull Button buttonSkipQuestion,
      @NonNull EditText editTextAge, @NonNull TextView textView1, @NonNull TextView textView2,
      @NonNull TextView textView3, @NonNull TextView textViewAge, @NonNull TextView textViewGuide) {
    this.rootView = rootView;
    this.buttonBack = buttonBack;
    this.buttonGuide = buttonGuide;
    this.buttonNext = buttonNext;
    this.buttonSkipQuestion = buttonSkipQuestion;
    this.editTextAge = editTextAge;
    this.textView1 = textView1;
    this.textView2 = textView2;
    this.textView3 = textView3;
    this.textViewAge = textViewAge;
    this.textViewGuide = textViewGuide;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityTagAgeBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityTagAgeBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_tag_age, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityTagAgeBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.button_back;
      ImageButton buttonBack = ViewBindings.findChildViewById(rootView, id);
      if (buttonBack == null) {
        break missingId;
      }

      id = R.id.button_guide;
      Button buttonGuide = ViewBindings.findChildViewById(rootView, id);
      if (buttonGuide == null) {
        break missingId;
      }

      id = R.id.button_next;
      Button buttonNext = ViewBindings.findChildViewById(rootView, id);
      if (buttonNext == null) {
        break missingId;
      }

      id = R.id.button_skip_question;
      Button buttonSkipQuestion = ViewBindings.findChildViewById(rootView, id);
      if (buttonSkipQuestion == null) {
        break missingId;
      }

      id = R.id.editText_age;
      EditText editTextAge = ViewBindings.findChildViewById(rootView, id);
      if (editTextAge == null) {
        break missingId;
      }

      id = R.id.textView1;
      TextView textView1 = ViewBindings.findChildViewById(rootView, id);
      if (textView1 == null) {
        break missingId;
      }

      id = R.id.textView2;
      TextView textView2 = ViewBindings.findChildViewById(rootView, id);
      if (textView2 == null) {
        break missingId;
      }

      id = R.id.textView3;
      TextView textView3 = ViewBindings.findChildViewById(rootView, id);
      if (textView3 == null) {
        break missingId;
      }

      id = R.id.textView_age;
      TextView textViewAge = ViewBindings.findChildViewById(rootView, id);
      if (textViewAge == null) {
        break missingId;
      }

      id = R.id.textView_guide;
      TextView textViewGuide = ViewBindings.findChildViewById(rootView, id);
      if (textViewGuide == null) {
        break missingId;
      }

      return new ActivityTagAgeBinding((ConstraintLayout) rootView, buttonBack, buttonGuide,
          buttonNext, buttonSkipQuestion, editTextAge, textView1, textView2, textView3, textViewAge,
          textViewGuide);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}