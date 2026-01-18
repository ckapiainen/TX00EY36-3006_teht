package app.lab01

class Major(var name: String, var students: ArrayList<Student> = ArrayList()) {
    fun addStudent(student: Student) {
        students.add(student)
    }

    fun stats(): Triple<Double, Double, Double> {
        val averages = students.map { it.weightedAverage() }
        return Triple(
            averages.min(),
            averages.max(),
            averages.average()
        )
    }

    fun stats(courseName: String): Triple<Double, Double, Double> {
        val grades = students.mapNotNull { student -> student.courses.find { it.name == courseName } }
            .map { it.grade }

        return Triple(
            grades.min(),
            grades.max(),
            grades.average()
        )
    }

}