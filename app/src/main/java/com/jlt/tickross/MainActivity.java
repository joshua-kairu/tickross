package com.jlt.tickross;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.wnafee.vector.compat.AnimatedVectorDrawable;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 Tickross

 Simple show of Android vector path potentials
 * <p/>
 * Copyright (C) 2016 Kairu Joshua Wambugu
 * <p/>
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * <p/>
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * <p/>
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see http://www.gnu.org/licenses/.
 */

// begin activity MainActivity
public class MainActivity extends AppCompatActivity {

    /** CONSTANTS */

    /** Integers */

    /** Strings */

    /** VARIABLES */

    /* Animated Vector Drawable Compats */

//    private AnimatedVectorDrawableCompat rotateLeftButtonAnimatedVectorDrawable;

    /* wnafee's Animated Vector Drawables */

    private AnimatedVectorDrawable rotateLeftTickToCrossAnimatedVectorDrawable;
    private AnimatedVectorDrawable rotateLeftCrossToTickAnimatedVectorDrawable;

    private AnimatedVectorDrawable rotateRightTickToCrossAnimatedVectorDrawable;
    private AnimatedVectorDrawable rotateRightCrossToTickAnimatedVectorDrawable;

//    private AnimatedVectorDrawable flipFrontToBackAnimatedVectorDrawable;
//    private AnimatedVectorDrawable flipBackToFrontAnimatedVectorDrawable;

    private AnimatedVectorDrawable rotateLeftButtonAnimatedVectorDrawable;
    private AnimatedVectorDrawable rotateRightButtonAnimatedVectorDrawable;

    /* Image Buttons */

//    @Bind( R.id.am_ib_flip )
//    ImageButton flipImageButton; // the button having the flipping

    @Bind( R.id.am_ib_rotate_left )
    ImageButton rotateLeftImageButton; // the button for rotating the tick cross to the left

    @Bind( R.id.am_ib_rotate_right )
    ImageButton rotateRightImageButton; // the button for rotating the tick cross to the right

    /* Image Views */

    @Bind( R.id.am_iv_tick_cross )
    ImageView tickCrossImageView; // the image view

    /* Primitives */

    private boolean showTick; // boolean to tell what we are animating - tick or cross
    private boolean showFlipToBack; // boolean to tell what we are animating in the flipping - front or back

    /** METHODS */

    /** Getters and Setters */

    /**
     * Overrides
     */

    @Override
    // begin onCreate
    protected void onCreate( Bundle savedInstanceState ) {

        // 0. super things
        // 1. use the main layout
        // 2. bind views
        // 3. initialize animated vectors
        // 4. start with the tick
        // 5. start with flip to back visible

        // 0. super things

        super.onCreate( savedInstanceState );

        // 1. use the main layout

        setContentView( R.layout.activity_main );

        // 2. bind views

        ButterKnife.bind( this );

        // 3. initialize animated vectors

        /*
         while wnafee's readme.md recommends using ResourcesCompat to inflate animations in code
         I seem unable to inflate it in this way without running into problems with casting from
         wnafee's AnimatedVectorDrawable to the android AnimatedVectorDrawable
         */

        rotateLeftTickToCrossAnimatedVectorDrawable = AnimatedVectorDrawable.create( this, getResources(),
                R.drawable.avd_rotate_left_tick_to_cross );
        rotateLeftCrossToTickAnimatedVectorDrawable = AnimatedVectorDrawable.create( this, getResources(),
                R.drawable.avd_rotate_left_cross_to_tick );

        rotateRightTickToCrossAnimatedVectorDrawable = AnimatedVectorDrawable.create( this, getResources(),
                R.drawable.avd_rotate_right_tick_to_cross );
        rotateRightCrossToTickAnimatedVectorDrawable = AnimatedVectorDrawable.create( this, getResources(),
                R.drawable.avd_rotate_right_cross_to_tick );

//        flipFrontToBackAnimatedVectorDrawable = AnimatedVectorDrawable.create( this, getResources(),
//              R.drawable.avd_button_flip_to_back );
//        flipBackToFrontAnimatedVectorDrawable = AnimatedVectorDrawable.create( this, getResources(),
//              R.drawable.avd_button_flip_to_front );

        rotateLeftButtonAnimatedVectorDrawable = AnimatedVectorDrawable.create( this, getResources(),
                R.drawable.avd_button_rotate_left );

        rotateRightButtonAnimatedVectorDrawable = AnimatedVectorDrawable.create( this, getResources(),
                R.drawable.avd_button_rotate_right );

        // 4. start with the tick

        showTick = true;

        // 5. start with flip to back visible

        showFlipToBack = true;

    } // end onCreate

    /** Other Methods */

    // begin method animate
    public void animate( View view, AnimatedVectorDrawable tickToCrossDrawable,
                         AnimatedVectorDrawable crossToTickDrawable ) {

        // 0. put the correct animation in the image view
        // 1. start the animation
        // 2. toggle the animation to be shown

        // 0. put the correct animation in the image view

        AnimatedVectorDrawable animatedVectorDrawable = ( showTick == true ) ? tickToCrossDrawable :
                crossToTickDrawable;

        tickCrossImageView.setImageDrawable( animatedVectorDrawable );

        // 1. start the animation

        animatedVectorDrawable.start();

        // 2. toggle the animation to be shown

        showTick = !showTick;

    } // end method animate

//    @OnClick( R.id.am_ib_flip )
    // begin onFlipButtonClick
    void onFlipButtonClick(){

        // 0. get the animation in the button
        // 1. animate it to show the flip
        // 2. animate the tick cross
        // 3. put the correct animation in the button
        // 4. toggle flip state

        // 0. get the animation in the button

//        AnimatedVectorDrawable animatedVectorDrawable = ( AnimatedVectorDrawable ) flipImageButton.getDrawable();

//        AnimatedVectorDrawable animatedVectorDrawable = ( showFlipToBack == true ) ? flipFrontToBackAnimatedVectorDrawable : flipBackToFrontAnimatedVectorDrawable;
//
//        flipImageButton.setImageDrawable( animatedVectorDrawable );
//
//        // 1. animate it to show the flip
//
//        animatedVectorDrawable.start();
//
//        // 2. animate the tick cross
//
//        animate( flipImageButton );
//
//        // 3. put the correct animation in the button
//
////        animatedVectorDrawable = ( showFlipToBack == true ) ? flipBackToFrontAnimatedVectorDrawable : flipFrontToBackAnimatedVectorDrawable;
////        flipImageButton.setImageDrawable( animatedVectorDrawable );
//
//        // 4. toggle flip state
//
//        showFlipToBack = ! showFlipToBack;

    } // end onFlipButtonClick

    @OnClick( R.id.am_ib_rotate_left )
    // begin onClickRotateLeftButton
    void onClickRotateLeftButton() {

        // 0. get the animated vector in the rotate left button
        // 1. start the animation on the button
        // 2. start the tick cross animation

        // 0. get the animated vector in the rotate left button

//        Drawable drawable = rotateLeftImageButton.getDrawable();

        // 1. start the animation on the button

//        if ( drawable instanceof Animatable ) { ( ( Animatable ) drawable ).start(); }

        // 2. start the tick cross animation

        rotateLeftImageButton.setImageDrawable( rotateLeftButtonAnimatedVectorDrawable );

        rotateLeftButtonAnimatedVectorDrawable.start();

        animate( rotateLeftImageButton, rotateLeftTickToCrossAnimatedVectorDrawable,
                rotateLeftCrossToTickAnimatedVectorDrawable );

    } // end onClickRotateLeftButton

    @OnClick( R.id.am_ib_rotate_right )
    // begin onClickRotateRightButton
    void onClickRotateRightButton() {

        // 0. get the animated vector in the rotate left button
        // 1. start the animation on the button
        // 2. start the tick cross animation

        // 0. get the animated vector in the rotate left button

//        Drawable drawable = rotateLeftImageButton.getDrawable();

        // 1. start the animation on the button

//        if ( drawable instanceof Animatable ) { ( ( Animatable ) drawable ).start(); }

        // 2. start the tick cross animation

        rotateRightImageButton.setImageDrawable( rotateRightButtonAnimatedVectorDrawable );

        rotateRightButtonAnimatedVectorDrawable.start();

        animate( rotateLeftImageButton, rotateRightTickToCrossAnimatedVectorDrawable,
                rotateRightCrossToTickAnimatedVectorDrawable );

    } // end onClickRotateRightButton

    /** INNER CLASSES */

} // end activity MainActivity