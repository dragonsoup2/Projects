namespace Assignment9.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class relationshipAdd : DbMigration
    {
        public override void Up()
        {
            AddColumn("dbo.LOLPlayers", "LOLTeam_Id", c => c.Int());
            AddColumn("dbo.Sponsors", "LOLTeam_Id", c => c.Int());
            CreateIndex("dbo.LOLPlayers", "LOLTeam_Id");
            CreateIndex("dbo.Sponsors", "LOLTeam_Id");
            AddForeignKey("dbo.LOLPlayers", "LOLTeam_Id", "dbo.LOLTeams", "Id");
            AddForeignKey("dbo.Sponsors", "LOLTeam_Id", "dbo.LOLTeams", "Id");
        }
        
        public override void Down()
        {
            DropForeignKey("dbo.Sponsors", "LOLTeam_Id", "dbo.LOLTeams");
            DropForeignKey("dbo.LOLPlayers", "LOLTeam_Id", "dbo.LOLTeams");
            DropIndex("dbo.Sponsors", new[] { "LOLTeam_Id" });
            DropIndex("dbo.LOLPlayers", new[] { "LOLTeam_Id" });
            DropColumn("dbo.Sponsors", "LOLTeam_Id");
            DropColumn("dbo.LOLPlayers", "LOLTeam_Id");
        }
    }
}
