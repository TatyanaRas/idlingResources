package ru.kkuzmichev.simpleappforespresso;


import android.view.View;

import androidx.recyclerview.widget.RecyclerView;
import androidx.test.espresso.matcher.BoundedMatcher;

import org.hamcrest.Description;
import org.hamcrest.Matcher;


public class CustomViewMatcher {


   public static BoundedMatcher<View, RecyclerView> recyclerViewSizeMatcher(final int matcherSize) {
       return new BoundedMatcher<View, RecyclerView>(RecyclerView.class) {

        private String result;

@Override
        public void describeTo(Description description) { // Доп. описание ошибки
                description.appendText("Requested list size: " + matcherSize);
                description.appendText("Actual list size: ");
                description.appendText(result);
            }

            @Override

            protected boolean matchesSafely(RecyclerView recyclerView) {//проверка
                int items = recyclerView.getAdapter().getItemCount();//факт
                result = "List size: " + items;
                return matcherSize == items;
            }
        };

    }


}
