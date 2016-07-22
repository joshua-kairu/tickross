package com.jlt.tickross;

import android.graphics.drawable.AnimatedVectorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import butterknife.Bind;
import butterknife.ButterKnife;

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

    /* Animated Vector Drawables */

    private AnimatedVectorDrawable tickToCrossAnimatedVectorDrawable;
    private AnimatedVectorDrawable crossToTickAnimatedVectorDrawable;

    /* Image Views */

    @Bind( R.id.am_iv_tick_cross )
    ImageView tickCrossImageView; // the image view

    /* Primitives */

    private boolean showTick; // boolean to tell what we are animating

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

        // 0. super things

        super.onCreate( savedInstanceState );

        // 1. use the main layout

        setContentView( R.layout.activity_main );

        // 2. bind views

        ButterKnife.bind( this );

        // 3. initialize animated vectors

        tickToCrossAnimatedVectorDrawable = ( AnimatedVectorDrawable ) getDrawable( R.drawable.avd_tick_to_cross );
        crossToTickAnimatedVectorDrawable = ( AnimatedVectorDrawable ) getDrawable( R.drawable.avd_cross_to_tick );

        // 4. start with the tick

        showTick = true;

    } // end onCreate

    /** Other Methods */

    // begin method animate
    public void animate( View view ) {

        // 0. put the correct animation in the image view
        // 1. start the animation
        // 2. toggle the animation to be shown

        // 0. put the correct animation in the image view

        AnimatedVectorDrawable animatedVectorDrawable = ( showTick == true ) ? tickToCrossAnimatedVectorDrawable : crossToTickAnimatedVectorDrawable;

        tickCrossImageView.setImageDrawable( animatedVectorDrawable );

        // 1. start the animation

        animatedVectorDrawable.start();

        // 2. toggle the animation to be shown

        showTick = !showTick;

    } // end method animate

    /** INNER CLASSES */

} // end activity MainActivity