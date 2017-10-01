suite('Runicorn.Obstacles', function() {
    
    setup(function(done) {
        game_speed = 1.3
        the_obstacles.push(new Obstacles())
        console.log(the_obstacles)
        done()
    })

    test('obstacle should have x of 600', function() {
        assert.equal(the_obstacles[0].x, 600)
    })

    test('obstacle should have y of 128', function() {
        assert.equal(the_obstacles[0].y, 128)
    })

    test('obstacle height should be 40', function() {
        assert.equal(the_obstacles[0].height, 25)
    })

    test('obstacle left should change x to 600', function() {
        the_obstacles[0].left()
        console.log("====", the_obstacles[1].x)
        assert.equal(the_obstacles[1].x, 600)
    })

    test('obstacle left should be function', function() {
        assert.isFunction(the_obstacles[0].left)
    })

    test('obstacle show should be function', function() {
        assert.isFunction(the_obstacles[0].show)
    })

})