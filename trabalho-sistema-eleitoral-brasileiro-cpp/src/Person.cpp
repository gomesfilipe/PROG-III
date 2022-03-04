#include "../include/Person.h"

Person::Person(const string& name, char gender, const string& birth) {
    this->name = name;
    this->gender = gender;
    this->birth = parseDate(birth, "%d/%m/%Y");
}

const string& Person::get_name() const {
    return this->name;
}

char Person::get_gender() const {
    return this->gender;
}

time_t Person::get_birth() const {
    return this->birth;
}

/**
 * @brief Calculates the person's age at a specific date.
 * @param date Specific date.
 * @return Person's age at a specific date. 
 */
int Person::age_at(const string& date) const {
    time_t calendar = parseDate(date, "%d/%m/%Y");
    struct tm* tm_calendar = localtime(&calendar);
    
    int mday_calendar = tm_calendar->tm_mday;
    int mon_calendar = tm_calendar->tm_mon;
    int year_calendar = tm_calendar->tm_year;

    struct tm* tm_birth = localtime(&this->birth);
    
    int mday_birth = tm_birth->tm_mday;
    int mon_birth = tm_birth->tm_mon;
    int year_birth = tm_birth->tm_year;

    int diff_years = year_calendar - year_birth;

    if(mon_calendar > mon_birth) {
        return diff_years;
    
    } else if(mon_calendar < mon_birth) {
        return diff_years - 1;
    
    } else {
        if(mday_calendar >= mday_birth) {
            return diff_years;
        
        } else {
            return diff_years - 1;
        }
    }
}

ostream& operator<<(ostream& out, const Person& person) {
    out << person.name << endl;
    out << person.gender << endl;
    out << formatDate(person.birth, "%d/%m/%Y") << endl;
    return out;
}
