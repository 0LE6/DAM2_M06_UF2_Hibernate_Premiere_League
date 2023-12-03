# DAM2_M06_UF2_Hibernate_Premiere_League
Practice number 3 from Formative Unite 2 of Modul 06. Using Hibernate and DAO Pattern to manage information of MySQL DataBase.

![image](https://github.com/0LE6/DAM2_M06_UF2_Hibernate_Premiere_League/assets/135649528/88259ac5-6a9f-410f-af60-b654f061e4a2)

# DAOManager Interface Refactoring

## A3 - Task Description

### A3.1 - Simplification of DAOManager Interface

The goal is to simplify the `DAOManager` interface by including the following methods:

- **AddTeam**
  - Adds a team using the entity manager (not JDBC stored procedures).
  - Implementation similar to the example in the main program handout.

- **DeleteTeam**
  - Deletes the team with the provided abbreviation.
  - Deletion is not performed if there are any associated Matches.

- **UpdateTeam**
  - Updates all fields of the team except the team abbreviation used for selection.
  - Returns the updated version of the team. Returns null if the team does not exist.

- **GetTeamByAbbr**
  - Returns the team associated with the exact abbreviation. Null if not found.

- **GetTeamByName**
  - Returns the team associated with the exact name. Null if not found.

- **GetAllTeams**
  - Returns all teams from the TEAMS table.

### A3.3 - Composite Keys

- **Player Table Addition**
  - Add the Player table to the premier2223 database with the fields PK = team_abv + player_id.
  - team_abv is also an FK referencing abv of TEAM table.

- **Player Class**
  - Add the Player class with a composite key.

- **Additional DAO Interface Methods**
  - **AddPlayer**
    - Adds a player to the Player table.

  - **ImportPlayers**
    - Reads the PLAYERS.XML file and adds players of the team for the 2223 season.
    - Returns the number of players inserted.
    - Pay attention to the search algorithm due to the sorted text file.

### A3.4 - One to Many Class Relation

- **One to Many Relationship**
  - Add a one-to-many relationship between TEAM and PLAYER.

- **Additional DAO Interface Method**
  - **AddTeam (with Players)**
    - Adds a team and all players from the provided list to the database.
    - Only persists the oneTeam team containing the list of players.

## Usage

Please refer to the updated DAOManager interface for the revised methods and their implementations.

