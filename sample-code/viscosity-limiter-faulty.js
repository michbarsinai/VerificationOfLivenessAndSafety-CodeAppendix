/* global bp */

/////
// A b-thread that should limit the viscosity of the batter to [-2, 2],
// but contains an off-by-one error.
/////


bp.registerBThread("ViscosityLimiter", function(){
    while ( true ) {
        var vEvent=bp.sync({waitFor:VISCOSITY_EVENTS});
        var currentViscosity = vEvent.data;
        var block;
        if ( Math.abs(currentViscosity) > VISCOSITY_BOUND ) {
            block = (currentViscosity>0) ? ADD_DRY : ADD_WET;
        } else {
            block = bp.none;
        }

        var evt = bp.sync({waitFor:ADDITION_EVENTS, block:block});
    }
});
