﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
// new...
using AutoMapper;
using Assignment9.Models;
using System.Security.Claims;
using System.IO;
using CsvHelper;

namespace Assignment9.Controllers
{
    public class Manager
    {
        // Reference to the data context
        private ApplicationDbContext ds = new ApplicationDbContext();

        // Declare a property to hold the user account for the current request
        // Can use this property here in the Manager class to control logic and flow
        // Can also use this property in a controller 
        // Can also use this property in a view; for best results, 
        // near the top of the view, add this statement:
        // var userAccount = new ConditionalMenu.Controllers.UserAccount(User as System.Security.Claims.ClaimsPrincipal);
        // Then, you can use "userAccount" anywhere in the view to render content
        public UserAccount UserAccount { get; private set; }

        public Manager()
        {
            // If necessary, add constructor code here

            // Initialize the UserAccount property
            UserAccount = new UserAccount(HttpContext.Current.User as ClaimsPrincipal);

            // Turn off the Entity Framework (EF) proxy creation features
            // We do NOT want the EF to track changes - we'll do that ourselves
            ds.Configuration.ProxyCreationEnabled = false;

            // Also, turn off lazy loading...
            // We want to retain control over fetching related objects
            ds.Configuration.LazyLoadingEnabled = false;
        }

        // ############################################################
        // RoleClaim

        public List<string> RoleClaimGetAllStrings()
        {
            return ds.RoleClaims.OrderBy(r => r.Name).Select(r => r.Name).ToList();
        }

        // Add methods below
        // Controllers will call these methods
        // Ensure that the methods accept and deliver ONLY view model objects and collections
        // The collection return type is almost always IEnumerable<T>

        // Suggested naming convention: Entity + task/action
        // For example:
        // ProductGetAll()
        // ProductGetById()
        // ProductAdd()
        // ProductEdit()
        // ProductDelete()

        public IEnumerable<LOLTeamBase> LOLTeamGetAll()
        {
            return Mapper.Map< IEnumerable<LOLTeamBase>>(ds.LOLTeams);
        }

        public LOLTeamWithDetail LOLTeamGetByIdWithDetail(int id)
        {
            var o = ds.LOLTeams.Include("Players").SingleOrDefault(t => t.Id == id);
            var s = Mapper.Map<LOLTeamWithDetail>(o);
            s.Players = Mapper.Map<IEnumerable<LOLPlayer>>(ds.LOLPlayers.Where(t => t.LOLTeamCode.Trim().Equals(o.Code)));
            s.PlayersCount = s.Players.Count();
            s.Sponsor = Mapper.Map<SponsorBase>(ds.Sponsors.FirstOrDefault(t => t.CompanyName.Trim().Equals(o.Sponsor)));

            if (s == null)
            {
                return null;
            }
            else
            {

                return s;
            }
        }

        public IEnumerable<LOLPlayerBase> LOLPLayerGetAll()
        {
            return Mapper.Map<IEnumerable<LOLPlayerBase>>(ds.LOLPlayers);
        }

        public LOLPlayerWithDetail LOLPlayerGetByIdWithDetail(int id)
        {
            var o = ds.LOLPlayers.Find(id);
            var s = Mapper.Map<LOLPlayerWithDetail>(o);

            s.LOLTeam = Mapper.Map <LOLTeamBase>(ds.LOLTeams.FirstOrDefault(t => t.Code.Trim().Equals(o.LOLTeamCode)));
            if (s == null)
            {
                return null;
            }
            else
            {
                return s;
            }
        }

        public IEnumerable<SponsorBase> SponsorGetAll()
        {
            return Mapper.Map<IEnumerable<SponsorBase>>(ds.Sponsors);
        }

        public SponsorWithDetail SponsorGetByIdWithDetail(int id)
        {
            var o = ds.Sponsors.Find(id);
            var s = Mapper.Map<SponsorWithDetail>(o);

            s.LOLTeam = Mapper.Map<LOLTeamBase>(ds.LOLTeams.FirstOrDefault(t => t.Sponsor.Trim().Equals(o.CompanyName)));
            if (s == null)
            {
                return null;
            }
            else
            {
                return s;
            }
        }

        // Add some programmatically-generated objects to the data store
        // Can write one method, or many methods - your decision
        // The important idea is that you check for existing data first
        // Call this method from a controller action/method

        public bool LoadData()
        {
            // User name
            var user = HttpContext.Current.User.Identity.Name;

            // Monitor the progress
            bool done = false;

            // ############################################################
            // RoleClaim

            if (ds.RoleClaims.Count() == 0)
            {
                ds.RoleClaims.Add(new RoleClaim { Name = "Coach" });
                ds.RoleClaims.Add(new RoleClaim { Name = "Coordinator" });
                ds.RoleClaims.Add(new RoleClaim { Name = "Staff" });
                ds.RoleClaims.Add(new RoleClaim { Name = "Manager" });

                ds.SaveChanges();
                done = true;
            }

            // ############################################################
            // Employee

            // Attention - 4 - Method to load data from the CSV file, with CsvHelper add-on

            if (ds.LOLTeams.Count() == 0)
            {
                // Add employees

                // Path to the CSV file
                var path = HttpContext.Current.Server.MapPath("~/App_Data/Team.csv");

                // Create a stream reader object, to read from the file system
                StreamReader sr = File.OpenText(path);

                // Create the CsvHelper object
                var csv = new CsvReader(sr);

                // Go through the data file
                while (csv.Read())
                {
                    // Read one line in the source file into a new object
                    LOLTeamAdd qb = csv.GetRecord<LOLTeamAdd>();

                    // Add the new object to the data store
                    ds.LOLTeams.Add(Mapper.Map<LOLTeam>(qb));
                }

                /*
                // Alternative... do it in two statements, instead of a loop
                // Create a collection, based on reading the CSV file contents
                var results = csv.GetRecords<EmployeeAdd>().ToList();
                // Add the collection in one statement
                ds.Employees.AddRange(Mapper.Map<IEnumerable<Employee>>(results));
                */

                ds.SaveChanges();
                done = true;

                // Clean up
                sr.Close();
                sr = null;
            }

            if (ds.LOLPlayers.Count() == 0)
            {
                // Add employees

                // Path to the CSV file
                var path = HttpContext.Current.Server.MapPath("~/App_Data/Player.csv");

                // Create a stream reader object, to read from the file system
                StreamReader sr = File.OpenText(path);

                // Create the CsvHelper object
                var csv = new CsvReader(sr);

                // Go through the data file
                while (csv.Read())
                {
                    // Read one line in the source file into a new object
                    LOLPlayerAdd qb = csv.GetRecord<LOLPlayerAdd>();

                    // Add the new object to the data store
                    ds.LOLPlayers.Add(Mapper.Map<LOLPlayer>(qb));
                }

                /*
                // Alternative... do it in two statements, instead of a loop
                // Create a collection, based on reading the CSV file contents
                var results = csv.GetRecords<EmployeeAdd>().ToList();
                // Add the collection in one statement
                ds.Employees.AddRange(Mapper.Map<IEnumerable<Employee>>(results));
                */

                ds.SaveChanges();
                done = true;

                // Clean up
                sr.Close();
                sr = null;
            }

            if (ds.Sponsors.Count() == 0)
            {
                // Add employees

                // Path to the CSV file
                var path = HttpContext.Current.Server.MapPath("~/App_Data/Sponsor.csv");

                // Create a stream reader object, to read from the file system
                StreamReader sr = File.OpenText(path);

                // Create the CsvHelper object
                var csv = new CsvReader(sr);

                // Go through the data file
                while (csv.Read())
                {
                    // Read one line in the source file into a new object
                    SponsorAdd qb = csv.GetRecord<SponsorAdd>();

                    // Add the new object to the data store
                    ds.Sponsors.Add(Mapper.Map<Sponsor>(qb));
                }

                /*
                // Alternative... do it in two statements, instead of a loop
                // Create a collection, based on reading the CSV file contents
                var results = csv.GetRecords<EmployeeAdd>().ToList();
                // Add the collection in one statement
                ds.Employees.AddRange(Mapper.Map<IEnumerable<Employee>>(results));
                */

                ds.SaveChanges();
                done = true;

                // Clean up
                sr.Close();
                sr = null;
            }

            return done;
        }


        public bool RemoveData()
        {
            try
            {
                foreach (var e in ds.RoleClaims)
                {
                    ds.Entry(e).State = System.Data.Entity.EntityState.Deleted;
                }
                ds.SaveChanges();

                return true;
            }
            catch (Exception)
            {
                return false;
            }
        }

        public bool RemoveDatabase()
        {
            try
            {
                return ds.Database.Delete();
            }
            catch (Exception)
            {
                return false;
            }
        }

    }

    // New "UserAccount" class for the authenticated user
    // Includes many convenient members to make it easier to render user account info
    // Study the properties and methods, and think about how you could use it
    public class UserAccount
    {
        // Constructor, pass in the security principal
        public UserAccount(ClaimsPrincipal user)
        {
            if (HttpContext.Current.Request.IsAuthenticated)
            {
                Principal = user;

                // Extract the role claims
                RoleClaims = user.Claims.Where(c => c.Type == ClaimTypes.Role).Select(c => c.Value);

                // User name
                Name = user.Identity.Name;

                // Extract the given name(s); if null or empty, then set an initial value
                string gn = user.Claims.SingleOrDefault(c => c.Type == ClaimTypes.GivenName).Value;
                if (string.IsNullOrEmpty(gn)) { gn = "(empty given name)"; }
                GivenName = gn;

                // Extract the surname; if null or empty, then set an initial value
                string sn = user.Claims.SingleOrDefault(c => c.Type == ClaimTypes.Surname).Value;
                if (string.IsNullOrEmpty(sn)) { sn = "(empty surname)"; }
                Surname = sn;

                IsAuthenticated = true;
                IsAdmin = user.HasClaim(ClaimTypes.Role, "Admin") ? true : false;
            }
            else
            {
                RoleClaims = new List<string>();
                Name = "anonymous";
                GivenName = "Unauthenticated";
                Surname = "Anonymous";
                IsAuthenticated = false;
                IsAdmin = false;
            }

            NamesFirstLast = $"{GivenName} {Surname}";
            NamesLastFirst = $"{Surname}, {GivenName}";
        }

        // Public properties
        public ClaimsPrincipal Principal { get; private set; }
        public IEnumerable<string> RoleClaims { get; private set; }

        public string Name { get; set; }

        public string GivenName { get; private set; }
        public string Surname { get; private set; }

        public string NamesFirstLast { get; private set; }
        public string NamesLastFirst { get; private set; }

        public bool IsAuthenticated { get; private set; }

        // Add other role-checking properties here as needed
        public bool IsAdmin { get; private set; }

        public bool HasRoleClaim(string value)
        {
            if (!IsAuthenticated) { return false; }
            return Principal.HasClaim(ClaimTypes.Role, value) ? true : false;
        }

        public bool HasClaim(string type, string value)
        {
            if (!IsAuthenticated) { return false; }
            return Principal.HasClaim(type, value) ? true : false;
        }
    }

}