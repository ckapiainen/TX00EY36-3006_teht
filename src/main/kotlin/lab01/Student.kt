package app.lab01


class Student(name: String, age: Int, var courses: ArrayList<CourseRecord> = ArrayList<CourseRecord>()) :
    Human(name, age) {
    fun addCourse(course: CourseRecord) {
        courses.add(course)
    }

    fun weightedAverage(): Double {
        return courses.sumOf { it.grade * it.credits } / courses.sumOf { it.credits }
    }

    fun weightedAverage(year: Int): Double {
        val yearCourses = courses.filter { it.yearCompleted == year }
        return yearCourses.sumOf { it.grade * it.credits } / yearCourses.sumOf { it.credits }
    }

    fun minMaxGrades(): Pair<Double, Double> {
        val min = courses.minOf { it.grade }
        val max = courses.maxOf { it.grade }
        return Pair(min, max)
    }
}